package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;

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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.item.ModItems;
import reascer.wom.world.item.WOMItems;
import yesman.epicfight.world.item.EpicFightItems;


public class MaskedGuard extends AbstractKombatantEntity {

    public MaskedGuard(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);      //CONSTRUCTOR
        //spawnEntityWithRandomWeapon(); //CALLING THE METHOD
        if(isEpicFightActive() && isWoMActive()) { //Checks if both mods are loaded
            spawnEntityWithAllWeapon();
        } else if(isWoMActive() && !isEpicFightActive()) { //Checks if wom is active and epic fight is not
            spawnEntityWithWomWeapon();
        } else if(isEpicFightActive() && !isWoMActive()) { //Checks if epic fight is active and wom is not
            spawnEntityWithEFWeapon();
        } else if(!isEpicFightActive() && !isWoMActive()) { //Checks if neither are active
            spawnEntityWithVanillaWeapon();
        }
    }

    //SKIN
        @Override
        public ResourceLocation getResourceLocation() {
            return new ResourceLocation(EpicArmory.MOD_ID, "textures/entity/maskedguard.png");
    }

    //ATTRIBUTES
    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0f)
                .add(Attributes.ATTACK_SPEED, 4.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.32f).build();
    }

    //THIS METHOD GIVES MASKED GUARD SPAWN WITH A VARIETY OF WEAPONS, IDEALLY IT WILL WORK BASED OFF MOD COMPAT
        /*public void spawnEntityWithRandomWeapon() {
            Item[] weaponOptions = {
                    ModItems.NAGINATA.get(),
                    EpicFightItems.IRON_SPEAR.get(), //If using EFM
                    EpicFightItems.IRON_TACHI.get(), //If using EFM

            };

            int randomIndex = this.random.nextInt(weaponOptions.length);
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(weaponOptions[randomIndex]));
    }*/

    public void spawnEntityWithWomWeapon() {
        Item[] weaponOptions = {
                WOMItems.WOODEN_STAFF.get(),
        };

        int randomIndex = this.random.nextInt(weaponOptions.length);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(weaponOptions[randomIndex]));
    }

    public void spawnEntityWithAllWeapon() {
        Item[] weaponOptions = {
                WOMItems.WOODEN_STAFF.get(),
                EpicFightItems.IRON_SPEAR.get(),
                Items.IRON_SWORD,
        };

        int randomIndex = this.random.nextInt(weaponOptions.length);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(weaponOptions[randomIndex]));
    }

    public void spawnEntityWithEFWeapon() {
        Item[] weaponOptions = {
                EpicFightItems.IRON_SPEAR.get(),
        };

        int randomIndex = this.random.nextInt(weaponOptions.length);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(weaponOptions[randomIndex]));
    }

    public void spawnEntityWithVanillaWeapon() {
        Item[] weaponOptions = {
                Items.IRON_SWORD,
        };

        int randomIndex = this.random.nextInt(weaponOptions.length);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(weaponOptions[randomIndex]));
    }

    //GOALS FOR MASKED GUARD
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));

    }

}

/*

    When assigning an Entity a single item:
    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.NAGINATA.get()));


    SOUND RELATED

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));

   MIGHT BE USEFUL

   public void restrictTo(BlockPos pPos, int pDistance) {
      this.restrictCenter = pPos;
      this.restrictRadius = (float)pDistance;


 */