package net.vancomb.epicarmory.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.vancomb.epicarmory.EpicArmory;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.world.item.EpicFightItemTier;
import yesman.epicfight.world.item.WeaponItem;

import java.util.ArrayList;
import java.util.List;

//This is wrong, was just messing around, change as needed ofcourse.

public class ShaolinKoinItem extends WeaponItem {
    @OnlyIn(Dist.CLIENT)
    private List<Component> tooltipExpand;
    private float attackDamage;
    private double attackSpeed;

    public ShaolinKoinItem(Item.Properties build) {
        super(EpicFightItemTier.UCHIGATANA, 0, -1.8F, build.defaultDurability(1666));
        this.attackDamage = 6.0F;
        this.attackSpeed = -1.8F;
        if (EpicFightMod.isPhysicalClient()) {
            this.tooltipExpand = new ArrayList<>();
            this.tooltipExpand.add(Component.literal(""));
            this.tooltipExpand.add(Component.translatable("item." + EpicArmory.MOD_ID + ".sento.tooltip"));
        }
    }
}
