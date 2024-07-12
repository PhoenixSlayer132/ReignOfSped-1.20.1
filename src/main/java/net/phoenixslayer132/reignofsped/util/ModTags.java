package net.phoenixslayer132.reignofsped.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.phoenixslayer132.reignofsped.ReignOfSped;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> PHOEN_ORE_BLOCK = createBlockTag("phoen_ore_block");
        public static final TagKey<Block> SUPERN_ORE_BLOCK = createBlockTag("supern_ore_block");
        public static final TagKey<Block> BLQ_ORE_BLOCK = createBlockTag("blq_ore_block");
        public static final TagKey<Block> DAR_ORE_BLOCK = createBlockTag("dar_ore_block");

        private static TagKey<Block> createBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(ReignOfSped.MOD_ID, name));
        }
        private static TagKey<Block> createCommonBlockTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }

    public static class Items {
        private static TagKey<Item> createItemTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(ReignOfSped.MOD_ID, name));
        }
        private static TagKey<Item> createCommonItemTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }
    }
}
