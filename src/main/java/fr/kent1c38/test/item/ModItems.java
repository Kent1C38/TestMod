package fr.kent1c38.test.item;

import fr.kent1c38.test.Test;
import fr.kent1c38.test.item.custom.DowsingRodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Test.MOD_ID);

    public static final RegistryObject<Item> RAW_RED_IRON = ITEMS.register("raw_red_iron", () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEST_TAB)));
    public static final RegistryObject<Item> RED_IRON_INGOT = ITEMS.register("red_iron_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEST_TAB)));
    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium", () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEST_TAB)));
    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod", () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModTab.TEST_TAB).durability(32)));

    //bouffe
    public static final RegistryObject<Item> CRISPS = ITEMS.register("crisps", () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEST_TAB).food(ModFoods.CRISPS)));

    //public static final RegistryObject<Item> CONTROLLER = ITEMS.register("controller", ()-> new Item(new Item.Properties().tab(ModCreativeModeTab)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
