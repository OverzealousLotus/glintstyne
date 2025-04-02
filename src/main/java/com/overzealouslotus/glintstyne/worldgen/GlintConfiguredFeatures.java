package com.overzealouslotus.glintstyne.worldgen;

import com.google.common.collect.ImmutableSet;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public final class GlintConfiguredFeatures {
  public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_SML =
    FeatureTools.configKey("ore_mochite_sml");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MOCHITE_LRG =
    FeatureTools.configKey("ore_mochite_lrg");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MORKITE_SML =
    FeatureTools.configKey("ore_morkite_sml");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MORKITE_LRG =
    FeatureTools.configKey("ore_morkite_lrg");

  public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
    HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
    RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    List<OreConfiguration.TargetBlockState> overworldMochiteOres = List.of(
      OreConfiguration.target(stoneReplaceables, GlintBlocks.MOCHITE_ORE.get().defaultBlockState()),
      OreConfiguration.target(deepslateReplaceables, GlintBlocks.DEEPSLATE_MOCHITE_ORE.get().defaultBlockState())
    );
    List<OreConfiguration.TargetBlockState> overworldMorkiteOres = List.of(
      OreConfiguration.target(deepslateReplaceables, GlintBlocks.DEEPSLATE_MORKITE_ORE.get().defaultBlockState())
    );
    ImmutableSet<OreConfiguration.TargetBlockState> specialMorkiteOres = ImmutableSet.of(
      OreConfiguration.target(deepslateReplaceables, GlintBlocks.DEEPSLATE_MORKITE_ORE.get().defaultBlockState()),
      OreConfiguration.target(new BlockMatchTest(GlintBlocks.DEEPSLATE_MORKITE_ORE.get()), Blocks.BEDROCK.defaultBlockState())
    );
    List<OreConfiguration.TargetBlockState> redstoneOres = List.of(
      OreConfiguration.target(stoneReplaceables, Blocks.REDSTONE_ORE.defaultBlockState()),
      OreConfiguration.target(deepslateReplaceables, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState())
    );


    FeatureTools.newConfig(context, ORE_MOCHITE_SML, Feature.ORE,
      new OreConfiguration(overworldMochiteOres, 4));
    FeatureTools.newConfig(context, ORE_MOCHITE_LRG, Feature.ORE,
      new OreConfiguration(overworldMochiteOres, 8));
    FeatureTools.newConfig(context, ORE_MORKITE_SML, Feature.ORE,
      new OreConfiguration(overworldMorkiteOres, 3));
    FeatureTools.newConfig(context, ORE_MORKITE_LRG, Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(16, 3, 3, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(newThresholdProvider(69L,
          new NormalNoise.NoiseParameters(-3, 1.0D),
          1.0F, 0.2F, 0.9F, Blocks.RAW_GOLD_BLOCK.defaultBlockState(),
          List.of(Blocks.BEDROCK.defaultBlockState()),
          List.of(Blocks.LAPIS_BLOCK.defaultBlockState())
        )), BlockPredicate.anyOf(BlockPredicate.matchesTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)))));
  }

  private static NoiseThresholdProvider newThresholdProvider(
    long seed, NormalNoise.NoiseParameters noise, float scale, float threshold, float highChance,
    BlockState fallback, List<BlockState> lowState, List<BlockState> highState

    ) {
    return new NoiseThresholdProvider(seed, noise, scale, threshold, highChance, fallback, lowState, highState);
  }
}
