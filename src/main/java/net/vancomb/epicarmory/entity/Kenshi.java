package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.item.ModItems;


public class Kenshi extends AbstractKombatantEntity {

    public Kenshi(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);

        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SENTO.get()));

    }

    @Override
    public ResourceLocation getResourceLoaction() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entity/kenshi.png");

    }

}
