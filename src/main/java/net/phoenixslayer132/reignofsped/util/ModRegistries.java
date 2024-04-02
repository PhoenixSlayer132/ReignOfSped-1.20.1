package net.phoenixslayer132.reignofsped.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.phoenixslayer132.reignofsped.item.ModItems;

public class ModRegistries {
    public static void registerROSThings() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LAMMOTH_STICK, 200);
    }
}
