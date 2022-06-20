package fr.kent1c38.test.util;


import fr.kent1c38.test.Test;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> DOWSING_ROD_VALUABLES = tag("dowsing_rod_valuables");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(Test.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name)
        {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> SAPPHIRE_GEMS = forgeTag("gems/sapphire");

        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(Test.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name)
        {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
