package net.vancomb.epicarmory.skills;

import net.minecraft.server.level.ServerPlayer;
import reascer.wom.gameasset.WOMAnimations;
import reascer.wom.gameasset.WOMSkills;
import reascer.wom.skill.passive.MeditationSkill;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.network.EpicFightNetworkManager;
import yesman.epicfight.network.server.SPPlayAnimation;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillDataManager;
import yesman.epicfight.skill.passive.PassiveSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class SentoPassive extends PassiveSkill {
    private static final UUID EVENT_UUID = UUID.fromString("010e5bfa-e6a2-11ec-8fea-0242ac120002");
    public static final SkillDataManager.SkillDataKey<Boolean> SHEATH = SkillDataManager.SkillDataKey.createDataKey(SkillDataManager.ValueType.BOOLEAN);
    public SentoPassive(Builder<? extends Skill> builder) {
        super(builder);
    }

    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        container.getDataManager().registerData(SHEATH);
        container.getExecuter().getEventListener().addEventListener(PlayerEventListener.EventType.ACTION_EVENT_SERVER, EVENT_UUID, (event) -> {
            StaticAnimation[] resetAnimations = new StaticAnimation[]{WOMAnimations.KATANA_AUTO_1, WOMAnimations.KATANA_AUTO_2, WOMAnimations.KATANA_AUTO_3, WOMAnimations.KATANA_DASH,
                    WOMAnimations.HERRSCHER_AUSROTTUNG, WOMAnimations.KATANA_SHEATHED_AUTO_1, WOMAnimations.KATANA_SHEATHED_AUTO_2, WOMAnimations.KATANA_SHEATHED_AUTO_3, WOMAnimations.KATANA_GUARD,
                    WOMAnimations.KATANA_GUARD_HIT, Animations.BIPED_HIT_SHORT, Animations.BIPED_HIT_LONG};
            StaticAnimation[] var3 = resetAnimations;
            int var4 = resetAnimations.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                StaticAnimation staticAnimation = var3[var5];
                if (event.getAnimation().equals(staticAnimation)) {
                    container.getSkill().setConsumptionSynchronize(event.getPlayerPatch(), 0.0F);
                    container.getSkill().setStackSynchronize(event.getPlayerPatch(), 0);
                }
            }
        });
        container.getExecuter().getEventListener().addEventListener(PlayerEventListener.EventType.SERVER_ITEM_USE_EVENT, EVENT_UUID, (event) -> {
            this.onReset(container);
        });
    }

    public void onRemoved(SkillContainer container) {
        container.getExecuter().getEventListener().removeListener(PlayerEventListener.EventType.ACTION_EVENT_SERVER, EVENT_UUID);
        container.getExecuter().getEventListener().removeListener(PlayerEventListener.EventType.SERVER_ITEM_USE_EVENT, EVENT_UUID);
    }

    public void onReset(SkillContainer container) {
        PlayerPatch<?> executer = container.getExecuter();
        if (!executer.isLogicalClient() && container.getDataManager().getDataValue(SHEATH)) {
            ServerPlayerPatch playerpatch = (ServerPlayerPatch)executer;
            container.getDataManager().setDataSync(SHEATH, false, playerpatch.getOriginal());
            playerpatch.modifyLivingMotionByCurrentItem();
            container.getSkill().setConsumptionSynchronize(playerpatch, 0.0F);
        }
    }

    public void setConsumption(SkillContainer container, float value) {
        PlayerPatch<?> executer = container.getExecuter();
        if (!executer.isLogicalClient() && this.consumption < value) {
            ServerPlayer serverPlayer = (ServerPlayer)executer.getOriginal();
            if (!(Boolean)container.getDataManager().getDataValue(SHEATH)) {
                container.getDataManager().setDataSync(SHEATH, true, serverPlayer);
                boolean flag = false;
                if (container.getExecuter().getSkill(WOMSkills.MEDITATION) == null) {
                    flag = true;
                } else if (container.getExecuter().getSkill(WOMSkills.MEDITATION).getDataManager().getDataValue(MeditationSkill.TIMER) == 0) {
                    flag = true;
                }

                if (flag) {
                    ((ServerPlayerPatch)executer).modifyLivingMotionByCurrentItem();
                    SPPlayAnimation msg3 = new SPPlayAnimation(WOMAnimations.KATANA_SHEATHE, serverPlayer.m_19879_(), 0.0F);
                    EpicFightNetworkManager.sendToAllPlayerTrackingThisEntityWithSelf(msg3, serverPlayer);
                }
            } else {
                ((ServerPlayerPatch)executer).modifyLivingMotionByCurrentItem();
            }

            container.getDataManager().setDataSync(SHEATH, true, serverPlayer);
        }

        super.setConsumption(container, value);
    }

    public boolean shouldDeactivateAutomatically(PlayerPatch<?> executer) {
        return true;
    }

    public float getCooldownRegenPerSecond(PlayerPatch<?> player) {
        return player.getOriginal().isUsingItem() ? 0.0F : 1.0F;
    }
}
