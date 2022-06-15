package fr.kent1c38.test.item.custom;

import fr.kent1c38.test.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DowsingRodItem extends Item
{
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide())
        {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++)
            {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if (isValuableBlock(blockBelow))
                {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock)
            {
                player.sendMessage(new TranslatableComponent("item.test.dowsing_rod.no_valuable"), player.getUUID());
                player.playSound(SoundEvents.VILLAGER_NO, 0.5f, 1f);
            }
        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), (player -> player.broadcastBreakEvent(player.getUsedItemHand())));

        return super.useOn(pContext);
    }

    public void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow)
    {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), player.getUUID());
        player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.5f, 1f);
    }

    private boolean isValuableBlock(Block block)
    {
        return block == Blocks.DIAMOND_ORE || block == ModBlocks.RED_IRON_ORE.get() || block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE
                || block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE
                || block == Blocks.DEEPSLATE_EMERALD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.DEEPSLATE_IRON_ORE
                || block == Blocks.DEEPSLATE_LAPIS_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.EMERALD_ORE || block == Blocks.GOLD_ORE
                || block == Blocks.IRON_ORE || block == Blocks.LAPIS_ORE || block == Blocks.NETHER_GOLD_ORE || block == Blocks.NETHER_QUARTZ_ORE
                || block == Blocks.REDSTONE_ORE;
    }
}
