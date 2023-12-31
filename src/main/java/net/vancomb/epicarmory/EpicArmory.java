package net.vancomb.epicarmory;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.vancomb.epicarmory.entity.ModEntityTypes;
import net.vancomb.epicarmory.item.ModItems;
import net.vancomb.epicarmory.skills.ModSkills;
import org.slf4j.Logger;

@Mod(EpicArmory.MOD_ID)
public class EpicArmory {
    public static final String MOD_ID = "epicarmory";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EpicArmory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModSkills.registerSkills();
        ModEntityTypes.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {}
}
