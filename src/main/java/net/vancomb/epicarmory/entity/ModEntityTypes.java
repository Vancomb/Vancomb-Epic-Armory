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

    //Register new entities here.

    public static final RegistryObject<EntityType<MaskedGuard>> MASKEDGUARD =
            ENTITY_TYPES.register("maskedguard",
                    () -> EntityType.Builder.of(MaskedGuard::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "maskedguard").toString()));

    public static final RegistryObject<EntityType<Kenshi>> KENSHI =
            ENTITY_TYPES.register("kenshi",
                    () -> EntityType.Builder.of(Kenshi::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "kenshi").toString()));

    /*

    public static final RegistryObject<EntityType<LiuKang>> LIUKANG =
            ENTITY_TYPES.register("liukang",
                    () -> EntityType.Builder.of(LiuKang::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "liukang").toString()));

    public static final RegistryObject<EntityType<KungLao>> KUNGLAO =
            ENTITY_TYPES.register("kunglao",
                    () -> EntityType.Builder.of(KungLao::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "kunglao").toString()));

    public static final RegistryObject<EntityType<Kano>> KANO =
            ENTITY_TYPES.register("kano",
                    () -> EntityType.Builder.of(Kano::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "kano").toString()));

    public static final RegistryObject<EntityType<Sonya>> SONYA =
            ENTITY_TYPES.register("sonya",
                    () -> EntityType.Builder.of(Sonya::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "sonya").toString()));

    public static final RegistryObject<EntityType<JohnnyCage>> JOHNNYCAGE =
            ENTITY_TYPES.register("johnnycage",
                    () -> EntityType.Builder.of(JohnnyCage::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "johnnycage").toString()));

    public static final RegistryObject<EntityType<Jax>> JAX =
            ENTITY_TYPES.register("jax",
                    () -> EntityType.Builder.of(Jax::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "jax").toString()));

    public static final RegistryObject<EntityType<Raiden>> RAIDEN =
            ENTITY_TYPES.register("raiden",
                    () -> EntityType.Builder.of(Raiden::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "raiden").toString()));

    public static final RegistryObject<EntityType<SubZero>> SUBZERO =
            ENTITY_TYPES.register("subzero",
                    () -> EntityType.Builder.of(SubZero::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "subzero").toString()));

    public static final RegistryObject<EntityType<Scorpion>> SCORPION =
            ENTITY_TYPES.register("scorpion",
                    () -> EntityType.Builder.of(Scorpion::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.9f)
                            .build(new ResourceLocation(EpicArmory.MOD_ID, "scorpion").toString()));


     */


    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }

}
