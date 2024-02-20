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

                        //Ores


                        //Ingots


                        //Ingot Blocks



                        //Wood



                        //
                    }).build());
    public static void registerItemGroups() {
        
    }
}
