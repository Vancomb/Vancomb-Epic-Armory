package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vancomb.epicarmory.EpicArmory;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EpicArmory.MOD_ID);

    public static final RegistryObject<EntityType<MaskedGuard>> MASKEDGUARD =
            ENTITY_TYPES.register("maskedguard",
                    () -> EntityType.Builder.of(MaskedGuard::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "maskedguard").toString()));

    public static void register(IEventBus modEventBus) { ENTITY_TYPES.register(modEventBus);

    }
}