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
import net.phoenixslayer132.reignofsped.item.custom.*;
import net.phoenixslayer132.reignofsped.item.custom.items.artifacts.GraciousAmuletItem;
import net.phoenixslayer132.reignofsped.item.custom.items.artifacts.UnknownItem;
import net.phoenixslayer132.reignofsped.item.custom.items.misc.LammothStakeItem;
import net.phoenixslayer132.reignofsped.item.custom.items.runes.LinyurdsRunesItem;
import net.phoenixslayer132.reignofsped.item.custom.items.scrolls.RestorationScrollItem;

public class ModItems {
    public static final Item RAW_PHOEN = registerItem("raw_phoen",
            new Item(new FabricItemSettings()));
    public static final Item RAW_SUPERN = registerItem("raw_supern",
            new Item(new FabricItemSettings()));
    public static final Item RAW_BLQ = registerItem("raw_blq",
            new Item(new FabricItemSettings()));
    public static final Item RAW_DAR = registerItem("raw_dar",
            new Item(new FabricItemSettings()));

    public static final Item PHOEN_INGOT = registerItem("phoen_ingot",
            new Item(new FabricItemSettings()));
    public static final Item SUPERN_INGOT = registerItem("supern_ingot",
            new Item(new FabricItemSettings()));
    public static final Item BLQ_INGOT = registerItem("blq_ingot",
            new Item(new FabricItemSettings()));
    public static final Item DAR_INGOT = registerItem("dar_ingot",
            new Item(new FabricItemSettings()));


    public static final Item LAMMOTH_STICK = registerItem("lammoth_stick",
            new Item(new FabricItemSettings()));


    public static final Item LAMMOTH_STAKE = registerItem("lammoth_stake",
            new LammothStakeItem(new FabricItemSettings().maxDamage(10)));
    public static final Item GRACIOUS_AMULET_ITEM = registerItem("gracious_amulet_item",
            new GraciousAmuletItem(new FabricItemSettings().maxDamage(999)));
    public static final Item UNKNOWN_ITEM = registerItem("unknown_item",
            new UnknownItem(new FabricItemSettings().fireproof().maxDamage(1)));
    public static final Item RESTORATION_SCROLL_ITEM = registerItem("restoration_scroll_item",
            new RestorationScrollItem(new FabricItemSettings().maxCount(8)));
    public static final Item LINYURDS_RUNES_ITEM = registerItem("linyurds_runes_item",
            new LinyurdsRunesItem(new FabricItemSettings().maxDamage(256)));


    public static final Item GOLDEN_BAMBOO = registerItem("golden_bamboo",
            new Item(new FabricItemSettings().food(ModFoodComponents.GOLDEN_BAMBOO)));
    public static final Item CHICKEN_TENDERS = registerItem("chicken_tenders",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHICKEN_TENDERS)));
    public static final Item CHICKEN_SANDWICH = registerItem("chicken_sandwich",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHICKEN_SANDWICH)));
    public static final Item CHICKEN_BUCKET = registerItem("chicken_bucket",
            new Item(new FabricItemSettings().food(ModFoodComponents.CHICKEN_BUCKET)));


    public static final Item CATFISH = registerItem("catfish",
            new Item(new FabricItemSettings().food(ModFoodComponents.CATFISH)));
    public static final Item COOKED_CATFISH = registerItem("cooked_catfish",
            new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_CATFISH)));
    public static final Item FRIED_CATFISH = registerItem("fried_catfish",
            new Item(new FabricItemSettings().food(ModFoodComponents.FRIED_CATFISH)));
    public static final Item SUPERN_CATFISH = registerItem("supern_catfish",
            new Item(new FabricItemSettings().food(ModFoodComponents.SUPERN_CATFISH)));



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

        //ingot
        entries.add(ModItems.PHOEN_INGOT);
        entries.add(ModItems.SUPERN_INGOT);
        entries.add(ModItems.BLQ_INGOT);
        entries.add(ModItems.DAR_INGOT);

        //foods
        entries.add(ModItems.GOLDEN_BAMBOO);
        entries.add(ModItems.CHICKEN_TENDERS);
        entries.add(ModItems.CHICKEN_SANDWICH);
        entries.add(ModItems.CHICKEN_BUCKET);
        entries.add(ModItems.CATFISH);
        entries.add(ModItems.COOKED_CATFISH);
        entries.add(ModItems.FRIED_CATFISH);
        entries.add(ModItems.SUPERN_CATFISH);
    }
    public static void registerModItems() {
        ReignOfSped.LOGGER.info("Registering Mod Items for " + ReignOfSped.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
