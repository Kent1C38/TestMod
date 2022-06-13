package fr.kent1c38.test.block;

import fr.kent1c38.test.Test;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Test.MOD_ID);



    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
