package net.vancomb.epicarmory.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vancomb.epicarmory.entity.AbstractKombatantEntity;
import net.vancomb.epicarmory.client.EAModelLayers;
import net.vancomb.epicarmory.client.model.AbstractKombatantEntityModel;

public class AbstractKombatantEntityRenderer extends HumanoidMobRenderer<AbstractKombatantEntity, AbstractKombatantEntityModel<AbstractKombatantEntity>> {

    public AbstractKombatantEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new AbstractKombatantEntityModel<>(context.bakeLayer(EAModelLayers.KOMBATANT_ENTITY)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractKombatantEntity entity) {
        return entity.getResourceLoaction();
    }

    /*public AbstractKombatantEntityRenderer(EntityRendererProvider.Context p_174169_, PlayerModel<AbstractKombatantEntity> p_174170_, float p_174171_) {
        super(p_174169_, p_174170_, p_174171_);

    }
    //Don't really know how this should be setup since there will be multiple mobs that extend the "AbstractKombatantEntity" class

    @Override
    public ResourceLocation getTextureLocation(AbstractKombatantEntity entity) {
        return entity.getResourceLoaction();
    }*/
}
