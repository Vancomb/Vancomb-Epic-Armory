package net.vancomb.epicarmory.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.entity.*;

@Mod.EventBusSubscriber(modid = EpicArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

    //To register a new mobs attributes just copy "event.put(ModEntityTypes.RANDOM_MOB.get(), MaskedGuard.setAttributes());"
    //and replace RANDOM_MOB with your mob
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.MASKEDGUARD.get(), MaskedGuard.setAttributes());
        event.put(ModEntityTypes.KENSHI.get(), Kenshi.setAttributes());

        /*
        event.put(ModEntityTypes.LIUKANG.get(), LiuKang.setAttributes());
        event.put(ModEntityTypes.KUNGLAO.get(), KungLao.setAttributes());
        event.put(ModEntityTypes.KANO.get(), Kano.setAttributes());
        event.put(ModEntityTypes.SONYA.get(), Sonya.setAttributes());
        event.put(ModEntityTypes.JOHNNYCAGE.get(), JohnnyCage.setAttributes());
        event.put(ModEntityTypes.JAX.get(), Jax.setAttributes());
        event.put(ModEntityTypes.RAIDEN.get(), Raiden.setAttributes());
        event.put(ModEntityTypes.SUBZERO.get(), SubZero.setAttributes());
        event.put(ModEntityTypes.SCORPION.get(), Scorpion.setAttributes());

         */

    }
}
