package net.atsderg.flavourfulandfoul.item.custom;

import net.atsderg.flavourfulandfoul.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class KindlingItem extends Item {
    private static final Map<Block, Block> KINDLE_MAP =
            Map.of(
                    Blocks.NETHERRACK, Blocks.MAGMA_BLOCK,
                    Blocks.SAND, Blocks.GLASS,
                    Blocks.RED_SAND, Blocks.ORANGE_STAINED_GLASS,
                    Blocks.COBBLESTONE, Blocks.STONE,
                    Blocks.STONE, Blocks.SMOOTH_STONE,
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS
            );

    public KindlingItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(KINDLE_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), KINDLE_MAP.get(clickedBlock).getDefaultState());

                context.getStack().decrement(1);

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
