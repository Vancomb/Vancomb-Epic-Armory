package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.vancomb.epicarmory.EpicArmory;

/* This mob, like others will not have any custom attacks or animations, it will use EPIC FIGHT combat through a datapack
which requires it to be a HumanoidModel */

public class MaskedGuard extends AbstractKombatantEntity {
    public MaskedGuard(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    @Override
    public ResourceLocation getResourceLoaction() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entity/maskedguard.png");
    }
}
