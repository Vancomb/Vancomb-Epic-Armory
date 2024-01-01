package net.vancomb.epicarmory.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.vancomb.epicarmory.EpicArmory;

public class EAModelLayers {
    public static final ModelLayerLocation KOMBATANT_ENTITY = register("kombatant_entity");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(new ResourceLocation(EpicArmory.MOD_ID, name), "main");
    }

    private static ModelLayerLocation register(String name, String layerName) {
        return new ModelLayerLocation(new ResourceLocation(EpicArmory.MOD_ID, name), layerName);
    }
}
