package net.vancomb.epicarmory.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vancomb.epicarmory.EpicArmory;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicArmory.MOD_ID);

                                            //MODELS

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

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}

 /*


                    //Cant figure out what the heck is going on here - I followed the EFM may for registering an item
    public static final RegistryObject<Item> HOOKSWORD = ITEMS.register("hooksword",
            () -> new HookswordItem(new Item.Properties().tab(ModTabs.EPIC_ARMORY).rarity(Rarity.RARE)));

  */