package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.vancomb.epicarmory.EpicArmory;


public class Kenshi extends AbstractKombatantEntity {

    public Kenshi(EntityType<? extends Monster> p_33002_, Level p_33003_) { super(p_33002_, p_33003_);}

    @Override
    public ResourceLocation getResourceLoaction() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entity/kenshi.png");

    }

}

/*

Kenshi will by default use `SentoItem`
I need to make a custom datapack for him

 */