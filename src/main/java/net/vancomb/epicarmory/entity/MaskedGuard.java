package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.vancomb.epicarmory.EpicArmory;


public class MaskedGuard extends AbstractKombatantEntity {
    public MaskedGuard(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ResourceLocation getResourceLoaction() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entity/maskedguard.png");

    }
}



/*
   protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD)); }

        protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
 */
