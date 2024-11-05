package net.atsderg.flavourfulandfoul.item;

import net.atsderg.flavourfulandfoul.FlavourfulAndFoul;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TESTING_ITEM = registerItem("testing_item", new Item(new Item.Settings()));
    public static final Item SILLY_TESTING_ITEM = registerItem("testing_item_silly", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FlavourfulAndFoul.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FlavourfulAndFoul.LOGGER.info("Registering Mod Items for" + FlavourfulAndFoul.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TESTING_ITEM);
            entries.add(SILLY_TESTING_ITEM);
        });
    }
}
