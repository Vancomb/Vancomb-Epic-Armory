package net.vancomb.epicarmory.event;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.entity.ModEntityTypes;
import net.vancomb.epicarmory.event.render.AbstractKombatantEntityRenderer;
import net.vancomb.epicarmory.item.ModItems;
import net.vancomb.epicarmory.event.render.RenderSento;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@Mod.EventBusSubscriber(modid = EpicArmory.MOD_ID , bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EARenderEngine {
    public EARenderEngine(){}

    @SubscribeEvent
    public static void registerRenderer(PatchedRenderersEvent.Add event) {
        event.addItemRenderer(ModItems.SENTO.get(), new RenderSento());
    }

    //Tried to register the renderer
    @SubscribeEvent
    public static void register(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.MASKEDGUARD.get(), AbstractKombatantEntityRenderer::new);
    }

}
