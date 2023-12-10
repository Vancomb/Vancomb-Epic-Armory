package net.vancomb.epicarmory.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final CreativeModeTab EPIC_ARMORY = new CreativeModeTab("epic_armory") {
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.HOOKSWORD.get());
        }
    };
}
