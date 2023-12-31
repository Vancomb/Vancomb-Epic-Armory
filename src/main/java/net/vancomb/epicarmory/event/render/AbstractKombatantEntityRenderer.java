package net.vancomb.epicarmory.event.render;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vancomb.epicarmory.entity.AbstractKombatantEntity;

public class AbstractKombatantEntityRenderer extends HumanoidMobRenderer<AbstractKombatantEntity, PlayerModel<AbstractKombatantEntity>> {

    public AbstractKombatantEntityRenderer(EntityRendererProvider.Context p_174169_, PlayerModel<AbstractKombatantEntity> p_174170_, float p_174171_) {
        super(p_174169_, p_174170_, p_174171_);

    }
//Don't really know how this should be setup since there will be multiple mobs that extend the "AbstractKombatantEntity" class

    @Override
    public ResourceLocation getTextureLocation(AbstractKombatantEntity entity) {
        return entity.getResourceLoaction();
    }

}
