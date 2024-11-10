package net.atsderg.flavourfulandfoul.datagen;

import net.atsderg.flavourfulandfoul.block.ModBlocks;
import net.atsderg.flavourfulandfoul.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
        // this generates all three json files needed for blocks
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TESTING_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_TESTING_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_TESTING_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TESTING_CRATE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TESTING_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TESTING_ITEM_YELLOW, Models.GENERATED);
        itemModelGenerator.register(ModItems.TESTING_ITEM_PINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TESTING_FOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TESTING_FUEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TESTING_CHISEL, Models.GENERATED);
    }
}
