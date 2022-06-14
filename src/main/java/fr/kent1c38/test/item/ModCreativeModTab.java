package fr.kent1c38.test.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab
{
    public static final CreativeModeTab TEST_TAB = new CreativeModeTab("test_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RAW_RED_IRON.get());
        }
    };
}
