package net.phoenixslayer132.reignofsped.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.ReignOfSped;
import net.phoenixslayer132.reignofsped.block.ModBlocks;

public class ModItems {
    public static final Item RAW_PHOEN = registerItem("raw_phoen",
            new Item(new FabricItemSettings()));
    public static final Item RAW_SUPERN = registerItem("raw_supern",
            new Item(new FabricItemSettings()));
    public static final Item RAW_BLQ = registerItem("raw_blq",
            new Item(new FabricItemSettings()));
    public static final Item RAW_DAR = registerItem("raw_dar",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ReignOfSped.MOD_ID, name), item);
    }
    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        //raw ore
        entries.add(RAW_PHOEN);
        entries.add(RAW_SUPERN);
        entries.add(RAW_BLQ);
        entries.add(RAW_DAR);

        //raw blocks
        entries.add(ModBlocks.RAW_PHOEN_BLOCK);
        entries.add(ModBlocks.RAW_SUPERN_BLOCK);
        entries.add(ModBlocks.RAW_BLQ_BLOCK);
        entries.add(ModBlocks.RAW_DAR_BLOCK);

        //ores
        entries.add(ModBlocks.PHOEN_ORE);
        entries.add(ModBlocks.SUPERN_ORE);
        entries.add(ModBlocks.BLQ_ORE);
        entries.add(ModBlocks.DAR_ORE);

    }
    public static void registerModItems() {
        ReignOfSped.LOGGER.info("Registering Mod Items for " + ReignOfSped.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
