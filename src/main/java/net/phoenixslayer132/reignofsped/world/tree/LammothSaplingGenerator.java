package net.phoenixslayer132.reignofsped.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.phoenixslayer132.reignofsped.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class LammothSaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.LAMMOTH_KEY;
    }
}
