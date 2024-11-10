package net.atsderg.flavourfulandfoul.datagen;

import net.atsderg.flavourfulandfoul.FlavourfulAndFoul;
import net.atsderg.flavourfulandfoul.block.ModBlocks;
import net.atsderg.flavourfulandfoul.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
// MAKE SURE that if you have two ways to craft the same item you use Identifier.of to make them different IDs
    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> TESTING_ITEM_YELLOW_SMELTABLE = List.of(ModItems.TESTING_ITEM, ModBlocks.TESTING_CRATE_BLOCK);

        offerSmelting(exporter, TESTING_ITEM_YELLOW_SMELTABLE, RecipeCategory.MISC, ModItems.TESTING_ITEM_YELLOW, 0.1f, 200, "testing_item_yellow");
        offerBlasting(exporter, TESTING_ITEM_YELLOW_SMELTABLE, RecipeCategory.MISC, ModItems.TESTING_ITEM_YELLOW, 0.1f, 100, "testing_item_yellow");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TESTING_ITEM, RecipeCategory.DECORATIONS, ModBlocks.TESTING_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TESTING_ITEM_YELLOW, RecipeCategory.DECORATIONS, ModBlocks.YELLOW_TESTING_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TESTING_ITEM_PINK, RecipeCategory.DECORATIONS, ModBlocks.PINK_TESTING_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TESTING_CHISEL)
                .pattern("D")
                .pattern("S")
                .input('D', Items.DIAMOND)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("GBY")
                .pattern("DAD")
                .pattern("YDG")
                .input('G', ModItems.TESTING_ITEM)
                .input('Y', ModItems.TESTING_ITEM_YELLOW)
                .input('D', Items.DIAMOND)
                .input('A', Items.AMETHYST_SHARD)
                .input('B', Items.DRAGON_BREATH)
                .criterion(hasItem(ModItems.TESTING_ITEM_YELLOW), conditionsFromItem(ModItems.TESTING_ITEM_YELLOW))
                .offerTo(exporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TESTING_FUEL)
                .input(ModItems.TESTING_ITEM_PINK)
                .input(Items.STICK, 8)
                .criterion(hasItem(ModItems.TESTING_ITEM_PINK), conditionsFromItem(ModItems.TESTING_ITEM_PINK))
                .offerTo(exporter, Identifier.of(FlavourfulAndFoul.MOD_ID, "testing_fuel_from_testing_item_pink"));

        // SmithingTransformRecipeJsonBuilder.create(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.TESTING_CHISEL, Items.NETHERITE_INGOT, RecipeCategory.TOOLS,)

    }
}
