package net.phoenixslayer132.reignofsped.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.ReignOfSped;
import net.phoenixslayer132.reignofsped.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup REIGN_OF_SPED_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ReignOfSped.MOD_ID, "reign_of_sped_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.reign_of_sped_group"))
                    .icon(() -> new ItemStack(ModBlocks.RAW_PHOEN_BLOCK)).entries((displayContext, entries) -> {
                        //Raw Ores
                        entries.add(ModItems.RAW_PHOEN);
                        entries.add(ModItems.RAW_SUPERN);
                        entries.add(ModItems.RAW_BLQ);
                        entries.add(ModItems.RAW_DAR);

                        //Raw Blocks
                        entries.add(ModBlocks.RAW_PHOEN_BLOCK);
                        entries.add(ModBlocks.RAW_SUPERN_BLOCK);
                        entries.add(ModBlocks.RAW_BLQ_BLOCK);
                        entries.add(ModBlocks.RAW_DAR_BLOCK);

                        //Ores
                        entries.add(ModBlocks.PHOEN_ORE);
                        entries.add(ModBlocks.SUPERN_ORE);
                        entries.add(ModBlocks.BLQ_ORE);
                        entries.add(ModBlocks.DAR_ORE);

                        //Ingots
                        /*
                        entries.add(ModItems.PHOENGOT);
                        entries.add(ModItems.SUPERNGOT);
                        entries.add(ModItems.BLQGOT);
                        entries.add(ModItems.DARGOT);
                        */

                        //Ingot Blocks
                        /*
                        entries.add(ModBlocks.PHOEN_BLOCK);
                        entries.add(ModBlocks.SUPERN_BLOCK);
                        entries.add(ModBlocks.BLQ_BLOCK);
                        entries.add(ModBlocks.DAR_BLOCK);
                        */

                        //Wood
                        entries.add(ModItems.LAMMOTH_STICK);
                        entries.add(ModBlocks.LAMMOTH_PLANKS);
                        entries.add(ModBlocks.LAMMOTH_WOOD);
                        entries.add(ModBlocks.LAMMOTH_LOG);
                        entries.add(ModBlocks.STRIPPED_LAMMOTH_WOOD);
                        entries.add(ModBlocks.STRIPPED_LAMMOTH_LOG);
                        entries.add(ModBlocks.LAMMOTH_LEAVES);
                        //entries.add(ModBlocks.LAMMOTH_SAPLING);

                        //Custom items
                        entries.add(ModItems.LAMMOTH_STAKE);
                        entries.add(ModItems.LAMMOTH_TEST_ITEM);

                        //Custom foods
                        entries.add(ModItems.GOLDEN_BAMBOO);


                    }).build());
    public static void registerItemGroups() {

    }
}
