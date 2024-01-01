package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.vancomb.epicarmory.EpicArmory;

/* There will be a variety of mobs that will all for the most part behave the same
but will have different skins, use different weapons, have different attributes, spawns etc. */

//To make a new mob that works with the Renderer you'd need to make sure it extends this class

public abstract class AbstractKombatantEntity extends Monster {
    public AbstractKombatantEntity(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f).build();
    }

    public ResourceLocation getResourceLoaction() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entities/whatever_your_texture_is.png");
    }
}
