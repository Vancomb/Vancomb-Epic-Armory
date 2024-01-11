package net.vancomb.epicarmory.client.render;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
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

    private void setModelProperties(AbstractKombatantEntity kombatant) {
        AbstractKombatantEntityModel<AbstractKombatantEntity> companionModel = this.getModel();
        HumanoidModel.ArmPose humanoidmodel$armpose = getArmPose(kombatant, InteractionHand.MAIN_HAND);
        HumanoidModel.ArmPose humanoidmodel$armpose1 = getArmPose(kombatant, InteractionHand.OFF_HAND);

        if (kombatant.getMainArm() == HumanoidArm.RIGHT) {
            companionModel.rightArmPose = humanoidmodel$armpose;
            companionModel.leftArmPose = humanoidmodel$armpose1;
        } else {
            companionModel.rightArmPose = humanoidmodel$armpose1;
            companionModel.leftArmPose = humanoidmodel$armpose;
        }
    }

    private static HumanoidModel.ArmPose getArmPose(AbstractKombatantEntity kombatant, InteractionHand hand) {
        ItemStack itemstack = kombatant.getItemInHand(hand);
        if (itemstack.isEmpty()) {
            return HumanoidModel.ArmPose.EMPTY;
        } else {
            if (kombatant.getUsedItemHand() == hand && kombatant.getUseItemRemainingTicks() > 0) {
                UseAnim useanim = itemstack.getUseAnimation();

                if (useanim == UseAnim.BOW) {
                    return HumanoidModel.ArmPose.BOW_AND_ARROW;
                }

                if (useanim == UseAnim.CROSSBOW && hand == kombatant.getUsedItemHand()) {
                    return HumanoidModel.ArmPose.CROSSBOW_CHARGE;
                }
            } else if (!kombatant.swinging && itemstack.is(Items.CROSSBOW) && CrossbowItem.isCharged(itemstack)) {
                return HumanoidModel.ArmPose.CROSSBOW_HOLD;
            }

            return HumanoidModel.ArmPose.ITEM;
        }
    }
}

/*

 */
