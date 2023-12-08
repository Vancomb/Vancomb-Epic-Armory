package net.vancomb.epicarmory.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
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
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<SwordItem> HOOKSWORD = ITEMS.register("hooksword",
            () -> new SwordItem(Tiers.NETHERITE, 11, -2.85f,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);

    }


}
