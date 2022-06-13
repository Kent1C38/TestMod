package fr.kent1c38.test.item;

import fr.kent1c38.test.Test;
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

    public static final RegistryObject<Item> RED_IRON = ITEMS.register("red_iron", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    //public static final RegistryObject<Item> CONTROLLER = ITEMS.register("controller", ()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
