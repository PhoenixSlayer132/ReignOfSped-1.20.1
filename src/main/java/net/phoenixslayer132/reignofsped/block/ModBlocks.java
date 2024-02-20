package net.phoenixslayer132.reignofsped.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.ReignOfSped;

public class ModBlocks {
    public static final Block RAW_PHOEN_BLOCK = registerBlock("raw_phoen_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RAW_SUPERN_BLOCK = registerBlock("raw_supern_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RAW_BLQ_BLOCK = registerBlock("raw_blq_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RAW_DAR_BLOCK = registerBlock("raw_dar_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block PHOEN_ORE = registerBlock("phoen_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    public static final Block SUPERN_ORE = registerBlock("supern_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    public static final Block BLQ_ORE = registerBlock("blq_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    public static final Block DAR_ORE = registerBlock("dar_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));

    private static Block registerBlock(String name, Block block){
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ReignOfSped.MOD_ID, name), block);
    }
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(ReignOfSped.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ReignOfSped.LOGGER.info("Registering ModBlocks for " + ReignOfSped.MOD_ID);
    }


}
