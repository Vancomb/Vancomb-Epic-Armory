package net.vancomb.epicarmory.item;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.entity.ModEntityTypes;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicArmory.MOD_ID);


    //ITEMS

    public static final RegistryObject<Item> KOMBAT_KOIN = ITEMS.register("kombat_koin",
            () -> new Item(new Item.Properties().tab(ModTabs.EPIC_ARMORY)));

    public static final RegistryObject<Item> EARTHREALM_KAMIDOGU = ITEMS.register("earthrealm_kamidogu",
            () -> new Item(new Item.Properties().tab(ModTabs.EPIC_ARMORY)));

    public static final RegistryObject<Item> NETHERREALM_KAMIDOGU = ITEMS.register("netherrealm_kamidogu",
            () -> new Item(new Item.Properties().tab(ModTabs.EPIC_ARMORY)));

    public static final RegistryObject<Item> OUTWORLD_KAMIDOGU = ITEMS.register("outworld_kamidogu",
            () -> new Item(new Item.Properties().tab(ModTabs.EPIC_ARMORY)));




    //WEAPONS

    public static final RegistryObject<SwordItem> STAFF = ITEMS.register("staff",
            () -> new SwordItem(Tiers.NETHERITE, 11, -2.85f,
                    new Item.Properties().tab(ModTabs.EPIC_ARMORY)));

    public static final RegistryObject<SwordItem> HOOKSWORD = ITEMS.register("hooksword",
            () -> new SwordItem(Tiers.NETHERITE, 11, -2.85f,
                    new Item.Properties().tab(ModTabs.EPIC_ARMORY)));

    public static final RegistryObject<Item> SENTO = ITEMS.register("sento",
            () -> new SentoItem(new Item.Properties().tab(ModTabs.EPIC_ARMORY).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> SENTO_SHEATH = ITEMS.register("sento_sheath",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<SwordItem> NAGINATA = ITEMS.register("naginata",
            () -> new SwordItem(Tiers.IRON, 11, -2.85f,
                    new Item.Properties().tab(ModTabs.EPIC_ARMORY)));


    //KOMBATANT SPAWN EGGS

    public static final RegistryObject<Item> MASKEDGUARD_SPAWN_EGG = ITEMS.register("maskedguard_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MASKEDGUARD, -1, -1,
                    new Item.Properties().tab(ModTabs.EPIC_ARMORY)));








    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}

 /*


                    //Cant figure out what the heck is going on here - I followed the EFM may for registering an item
    public static final RegistryObject<Item> HOOKSWORD = ITEMS.register("hooksword",
            () -> new HookswordItem(new Item.Properties().tab(ModTabs.EPIC_ARMORY).rarity(Rarity.RARE)));

  */