package net.phoenixslayer132.reignofsped.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.phoenixslayer132.reignofsped.ReignOfSped;
import net.phoenixslayer132.reignofsped.world.tree.LammothSaplingGenerator;

public class ModBlocks {
    public static final Block RAW_PHOEN_BLOCK = registerBlock("raw_phoen_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RAW_SUPERN_BLOCK = registerBlock("raw_supern_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RAW_BLQ_BLOCK = registerBlock("raw_blq_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block RAW_DAR_BLOCK = registerBlock("raw_dar_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final Block PHOEN_BLOCK = registerBlock("phoen_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block SUPERN_BLOCK = registerBlock("supern_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block BLQ_BLOCK = registerBlock("blq_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block DAR_BLOCK = registerBlock("dar_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final Block PHOEN_ORE = registerBlock("phoen_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).luminance((state) -> {
                return 3;})));
    public static final Block SUPERN_ORE = registerBlock("supern_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE)));
    public static final Block BLQ_ORE = registerBlock("blq_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.PRISMARINE)));
    public static final Block DAR_ORE = registerBlock("dar_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));

    public static final Block LINYURDS_RUNES_BLOCK = registerBlock("linyurds_runes_block",
            new Block(FabricBlockSettings.create().collidable(true).breakInstantly().dropsNothing()));

    public static final Block LAMMOTH_PLANKS = registerBlock("lammoth_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)));
    public static final Block LAMMOTH_LEAVES = registerBlock("lammoth_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_LEAVES)));


    public static final Block LAMMOTH_LOG = registerBlock("lammoth_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_LOG)));
    public static final Block LAMMOTH_WOOD = registerBlock("lammoth_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_WOOD)));
    public static final Block STRIPPED_LAMMOTH_LOG = registerBlock("stripped_lammoth_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final Block STRIPPED_LAMMOTH_WOOD = registerBlock("stripped_lammoth_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_DARK_OAK_WOOD)));

    public static final Block LAMMOTH_SAPLING = registerBlock("lammoth_sapling",
            new SaplingBlock(new LammothSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

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
