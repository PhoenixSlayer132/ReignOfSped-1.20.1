package net.phoenixslayer132.reignofsped.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.phoenixslayer132.reignofsped.block.ModBlocks;
import net.phoenixslayer132.reignofsped.item.ModItems;

public class ModRegistries {
    public static void registerROSThings() {
        registerFuels();
        registerStrippables();
        registerFlammables();
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.LAMMOTH_LOG, ModBlocks.STRIPPED_LAMMOTH_LOG);
        StrippableBlockRegistry.register(ModBlocks.LAMMOTH_WOOD, ModBlocks.STRIPPED_LAMMOTH_WOOD);
    }

    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LAMMOTH_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LAMMOTH_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LAMMOTH_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LAMMOTH_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LAMMOTH_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LAMMOTH_LEAVES, 30, 60);
    }
    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LAMMOTH_STICK, 200);
    }
}
