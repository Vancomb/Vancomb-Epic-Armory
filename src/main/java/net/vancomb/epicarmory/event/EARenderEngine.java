package net.vancomb.epicarmory.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.client.EAModelLayers;
import net.vancomb.epicarmory.entity.ModEntityTypes;
import net.vancomb.epicarmory.client.model.AbstractKombatantEntityModel;
import net.vancomb.epicarmory.client.render.AbstractKombatantEntityRenderer;
import net.vancomb.epicarmory.item.ModItems;
import net.vancomb.epicarmory.client.render.RenderSento;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@Mod.EventBusSubscriber(modid = EpicArmory.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EARenderEngine {
    public EARenderEngine() {
    }

    @SubscribeEvent
    public static void registerRenderer(PatchedRenderersEvent.Add event) {
        event.addItemRenderer(ModItems.SENTO.get(), new RenderSento());
    }

    @SubscribeEvent
    public static void registerEntityLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EAModelLayers.KOMBATANT_ENTITY, AbstractKombatantEntityModel::createBodyLayer);
    }

    //To register a new mobs renderer just copy "event.registerEntityRenderer(ModEntityTypes.RANDOM_MOB.get(), AbstractKombatantEntityRenderer::new);"
    //and replace RANDOM_MOB with your mob
    @SubscribeEvent
    public static void register(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.MASKEDGUARD.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KENSHI.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.SUBZERO.get(), AbstractKombatantEntityRenderer::new);
/*
        event.registerEntityRenderer(ModEntityTypes.LIUKANG.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KUNGLAO.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KANO.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.SONYA.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.JOHNNYCAGE.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.JAX.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.RAIDEN.get(), AbstractKombatantEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.SCORPION.get(), AbstractKombatantEntityRenderer::new);


 */

    }
}
