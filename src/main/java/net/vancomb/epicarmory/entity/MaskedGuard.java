package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
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
