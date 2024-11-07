package net.atsderg.flavourfulandfoul.item;

import net.atsderg.flavourfulandfoul.FlavourfulAndFoul;
import net.atsderg.flavourfulandfoul.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TESTING_ITEM = registerItem("testing_item", new Item(new Item.Settings()));
    public static final Item TESTING_ITEM_YELLOW = registerItem("testing_item_yellow", new Item(new Item.Settings()));
    public static final Item TESTING_ITEM_PINK = registerItem("testing_item_pink", new Item(new Item.Settings()));

    public static final Item TESTING_CHISEL = registerItem("testing_chisel", new ChiselItem(new Item.Settings().maxDamage(64)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FlavourfulAndFoul.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FlavourfulAndFoul.LOGGER.info("Registering Mod Items for" + FlavourfulAndFoul.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TESTING_ITEM);
            entries.add(TESTING_ITEM_YELLOW);
        });
    }
}
