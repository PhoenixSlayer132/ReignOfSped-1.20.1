package net.phoenixslayer132.reignofsped.world;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.phoenixslayer132.reignofsped.util.ModTags;
import net.phoenixslayer132.reignofsped.block.ModBlocks;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;
import net.phoenixslayer132.reignofsped.ReignOfSped;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> LAMMOTH_KEY = registerKey("lammoth");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLQ_ORE_KEY = registerKey("blq_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PHOEN_ORE_KEY = registerKey("phoen_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SUPERN_ORE_KEY = registerKey("supern_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, LAMMOTH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.LAMMOTH_LOG),
                new StraightTrunkPlacer(4, 6, 3),
                BlockStateProvider.of(ModBlocks.LAMMOTH_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 4)).build());

        RuleTest magmaReplaceables = new BlockMatchRuleTest(Blocks.MAGMA_BLOCK);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);
        RuleTest prismarineReplaceables = new BlockMatchRuleTest(Blocks.PRISMARINE);

        List<OreFeatureConfig.Target> overworldBlqOre =
                List.of(OreFeatureConfig.createTarget(prismarineReplaceables, ModBlocks.BLQ_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherPhoenOre =
                List.of(OreFeatureConfig.createTarget(magmaReplaceables, ModBlocks.PHOEN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endSupernOre =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ModBlocks.SUPERN_ORE.getDefaultState()));

        register(context, BLQ_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBlqOre, 2));
        register(context, PHOEN_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPhoenOre, 2));
        register(context, SUPERN_ORE_KEY, Feature.ORE, new OreFeatureConfig(endSupernOre, 2));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ReignOfSped.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
