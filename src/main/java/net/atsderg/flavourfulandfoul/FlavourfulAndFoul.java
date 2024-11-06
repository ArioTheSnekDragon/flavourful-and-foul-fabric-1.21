package net.atsderg.flavourfulandfoul;

import net.atsderg.flavourfulandfoul.block.ModBlocks;
import net.atsderg.flavourfulandfoul.item.ModItemGroups;
import net.atsderg.flavourfulandfoul.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlavourfulAndFoul implements ModInitializer {
	public static final String MOD_ID = "flavourfulandfoul";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}