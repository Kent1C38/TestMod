package fr.kent1c38.test.item.custom;

import fr.kent1c38.test.block.ModBlocks;
import fr.kent1c38.test.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
                BlockState blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockBelow))
                {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow.getBlock());
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

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown())
        {
            pTooltipComponents.add(new TranslatableComponent("tooltip.test.dowsing_rod.tooltip.shift"));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("tooltip.test.dowsing_rod.tooltip"));
        }
    }

    public void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow)
    {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), player.getUUID());
        player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.5f, 1f);
    }

    private boolean isValuableBlock(BlockState state)
    {
        return state.is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }

}
