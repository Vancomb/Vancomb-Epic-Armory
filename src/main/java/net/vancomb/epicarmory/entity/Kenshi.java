package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.item.ModItems;

//Kenshi will get a boss bar
//Sento renderer needs to be fixed, positioned better.
//Needs to get sounds (Maybe this should be done in the superclass?)
//Needs a custom boss bar texture
//Make it so KENSHI drops Sento upon death
//Make it so he doesn't despawn

public class Kenshi extends AbstractKombatantEntity {


    //BOSS BAR | HOWEVER I DON'T KNOW IF SOME PARTS ARE NECESSARY ([.setDarkenScreen(true);])
    //Need to figure out how to use a custom boss bar texture.
    private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public Kenshi(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);

        //MAKES KENSHI SPAWN WITH SENTO
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SENTO.get()));

    }

    //SKIN
    @Override
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entity/kenshi.png");

    }

    //ATTRIBUTES
    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D) //2 pts = 1 Heart
                .add(Attributes.ATTACK_DAMAGE, 1.0f)
                .add(Attributes.ATTACK_SPEED, 4.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.32f).build();
    }

    //GOALS FOR KENSHI
    //Needs to be fleshed out more.
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));

    }

    //UPDATES THE BOSS BAR PROGRESS DURING EACH TICK
    @Override
    public void aiStep() {
        super.aiStep();

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());

    }

    //EXPLANATION? I guess this has to do with when the boss bar appears?
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    //EXPLANATION? Therefore, this has to do with it disappearing after death I assume...
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }
}

/*
    *TRYING TO ADD BOSS BAR*

    bossBar = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);
    ServerBossEvent bossBar = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);

    @Override
    public void aiStep() {
        super.aiStep();

        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.put("BossBar", this.bossBar.save());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.bossBar.load(compound.getCompound("BossBar"));
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        this.bossBar.addPlayer(this.getCommandSenderWorld().getPlayers());
    }

    @Override
    public void onRemovedFromWorld() {
        super.onRemovedFromWorld();
        this.bossBar.removeAllPlayers();
    }

}
 */