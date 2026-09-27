package net.hyper.chromakeys;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.hyper.silliestlib.SilliestLib;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TestBlock;
import net.minecraft.world.level.block.state.properties.TestBlockMode;

import static net.hyper.silliestlib.utils.SilliestLibRegUtils.regBlock;
import static net.hyper.silliestlib.utils.SilliestLibRegUtils.regItem;

public class ChromaKeys implements ModInitializer {
	public static final String MOD_ID = "chromakeys";

	public static Block chromaKeyBlock(String id) {
		return regBlock(id, properties -> new Block(properties.lightLevel((state) -> 15).noOcclusion().noTerrainParticles().strength(-1.0F, 3600000.0F).noLootTable().isValidSpawn(Blocks::never)));
	}
	public static Item chromaKeyItem(String id, Block block) {
		return regItem(id, properties -> new BlockItem(block, properties.rarity(Rarity.EPIC)));
	}

	@Override
	public void onInitialize() {
		SilliestLib.init(MOD_ID);

		Block RED_CHROMA_KEY = chromaKeyBlock("red_chroma_key");
		Block GREEN_CHROMA_KEY = chromaKeyBlock("green_chroma_key");
		Block BLUE_CHROMA_KEY = chromaKeyBlock("blue_chroma_key");
		Block BLACK_CHROMA_KEY = chromaKeyBlock("black_chroma_key");
		Block WHITE_CHROMA_KEY = chromaKeyBlock("white_chroma_key");
		Item RED_CHROMA_KEY_ITEM = chromaKeyItem("red_chroma_key", RED_CHROMA_KEY);
		Item GREEN_CHROMA_KEY_ITEM = chromaKeyItem("green_chroma_key", GREEN_CHROMA_KEY);
		Item BLUE_CHROMA_KEY_ITEM = chromaKeyItem("blue_chroma_key", BLUE_CHROMA_KEY);
		Item BLACK_CHROMA_KEY_ITEM = chromaKeyItem("black_chroma_key", BLACK_CHROMA_KEY);
		Item WHITE_CHROMA_KEY_ITEM = chromaKeyItem("white_chroma_key", WHITE_CHROMA_KEY);

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.OP_BLOCKS).register(entries -> {
			entries.insertAfter(TestBlock.setModeOnStack(new ItemStack(Items.TEST_BLOCK), TestBlockMode.ACCEPT), RED_CHROMA_KEY_ITEM, GREEN_CHROMA_KEY_ITEM, BLUE_CHROMA_KEY_ITEM, BLACK_CHROMA_KEY_ITEM, WHITE_CHROMA_KEY_ITEM);
		});
	}
}
