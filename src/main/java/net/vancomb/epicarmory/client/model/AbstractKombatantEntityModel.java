package net.vancomb.epicarmory.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.vancomb.epicarmory.entity.AbstractKombatantEntity;

public class AbstractKombatantEntityModel<T extends AbstractKombatantEntity> extends HumanoidModel<T>  {
    public AbstractKombatantEntityModel(ModelPart p_170677_) {
        super(p_170677_);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        return LayerDefinition.create(meshdefinition, 64, 32);

    }
}
