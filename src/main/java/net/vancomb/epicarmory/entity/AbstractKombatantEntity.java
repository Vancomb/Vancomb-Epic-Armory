package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.vancomb.epicarmory.EpicArmory;

/* There will be a variety of mobs that will all for the most part behave the same
but will have different skins, use different weapons, have different attributes, spawns etc. */

//To make a new mob that works with the Renderer you'd need to make sure it extends this class

public abstract class AbstractKombatantEntity extends Monster {

    public AbstractKombatantEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public ResourceLocation getResourceLocation() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entities/whatever_your_texture_is.png");
    }

    public boolean isEpicFightActive() {
        return ModList.get().isLoaded("epicfight");
    }

    public boolean isWoMActive() {
        return ModList.get().isLoaded("wom");
    }
}

/*

    *One way of getting entity to use a weapon:

    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));

    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.NAGINATA.get())); (this worked)

 */