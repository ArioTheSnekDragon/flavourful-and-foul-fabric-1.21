package net.atsderg.flavourfulandfoul.item;

import net.atsderg.flavourfulandfoul.FlavourfulAndFoul;
import net.atsderg.flavourfulandfoul.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TESTING_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FlavourfulAndFoul.MOD_ID, "testing_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SILLY_TESTING_ITEM))
                    .displayName(Text.translatable("itemgroup.flavourfulandfoul.testing_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TESTING_ITEM);
                        entries.add(ModItems.SILLY_TESTING_ITEM);
                        entries.add(ModBlocks.TESTING_BLOCK);
                        entries.add(ModBlocks.YELLOW_TESTING_BLOCK);

                    }).build());
/*
    public static final ItemGroup TESTING_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FlavourfulAndFoul.MOD_ID, "testing_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.TESTING_BLOCK))
                    .displayName(Text.translatable("itemgroup.flavourfulandfoul.testing_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TESTING_BLOCK);
                        entries.add(ModBlocks.YELLOW_TESTING_BLOCK);

                    }).build());
*/


    public static void registerItemGroups() {
        FlavourfulAndFoul.LOGGER.info("Registering Item Groups for " + FlavourfulAndFoul.MOD_ID);
    }
}