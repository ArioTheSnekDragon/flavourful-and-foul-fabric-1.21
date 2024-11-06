package net.atsderg.flavourfulandfoul.block;

import net.atsderg.flavourfulandfoul.FlavourfulAndFoul;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TESTING_BLOCK = registerBlock("testing_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.CALCITE)));

    public static final Block YELLOW_TESTING_BLOCK = registerBlock("testing_block_yellow",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.CALCITE)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FlavourfulAndFoul.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FlavourfulAndFoul.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks( ) {
        FlavourfulAndFoul.LOGGER.info("Registering Mod Blocks for " + FlavourfulAndFoul.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.TESTING_BLOCK);
            entries.add(ModBlocks.YELLOW_TESTING_BLOCK);
        });
    }
}
