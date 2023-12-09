package net.vancomb.epicarmory.capabilities.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.skills.ModSkills;
import net.vancomb.epicarmory.skills.SentoPassive;
import reascer.wom.gameasset.WOMAnimations;
import reascer.wom.gameasset.WOMColliders;
import reascer.wom.gameasset.WOMSkills;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = EpicArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EAWeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> SATSUJIN = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .category(CapabilityItem.WeaponCategories.UCHIGATANA)
                .styleProvider((entitypatch) -> {
                    if (entitypatch instanceof PlayerPatch) {
                        PlayerPatch<?> playerpatch = (PlayerPatch<?>)entitypatch;
                        if (playerpatch.getSkill(SkillSlots.WEAPON_PASSIVE).getDataManager().hasData(SentoPassive.SHEATH) &&
                                playerpatch.getSkill(SkillSlots.WEAPON_PASSIVE).getDataManager().getDataValue(SentoPassive.SHEATH)) {
                            return CapabilityItem.Styles.SHEATH;
                        }
                    }
                    return CapabilityItem.Styles.TWO_HAND;
                })
                .passiveSkill(ModSkills.SENTO_PASSIVE)
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .collider(WOMColliders.KATANA)
                .canBePlacedOffhand(false)
                .newStyleCombo(CapabilityItem.Styles.SHEATH, WOMAnimations.KATANA_SHEATHED_AUTO_1, WOMAnimations.KATANA_SHEATHED_AUTO_2, WOMAnimations.KATANA_SHEATHED_AUTO_3, WOMAnimations.KATANA_SHEATHED_DASH, WOMAnimations.HERRSCHER_AUSROTTUNG)
                .newStyleCombo(CapabilityItem.Styles.TWO_HAND, WOMAnimations.KATANA_AUTO_1, WOMAnimations.KATANA_AUTO_2, WOMAnimations.KATANA_AUTO_3, WOMAnimations.KATANA_DASH, WOMAnimations.HERRSCHER_AUSROTTUNG)
                .newStyleCombo(CapabilityItem.Styles.MOUNT, Animations.SWORD_MOUNT_ATTACK)
                .innateSkill(CapabilityItem.Styles.SHEATH,(itemstack) -> WOMSkills.SAKURA_STATE)
                .innateSkill(CapabilityItem.Styles.TWO_HAND,(itemstack) -> WOMSkills.SAKURA_STATE)
                .comboCancel((style) -> {
                    return false;
                })
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_UCHIGATANA)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FLOAT, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FALL, WOMAnimations.KATANA_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.IDLE, WOMAnimations.KATANA_SHEATHED_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.KNEEL,  WOMAnimations.KATANA_SHEATHED_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.WALK,  WOMAnimations.KATANA_SHEATHED_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.CHASE,  WOMAnimations.KATANA_SHEATHED_RUN)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.RUN,  WOMAnimations.KATANA_SHEATHED_RUN)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.SNEAK,  WOMAnimations.KATANA_SHEATHED_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.SWIM,  WOMAnimations.KATANA_SHEATHED_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.FLOAT,  WOMAnimations.KATANA_SHEATHED_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.SHEATH, LivingMotions.FALL, WOMAnimations.KATANA_SHEATHED_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, WOMAnimations.KATANA_GUARD);
        return builder;
    };
}
