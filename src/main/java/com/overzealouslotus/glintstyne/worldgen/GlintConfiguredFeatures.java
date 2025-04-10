package com.overzealouslotus.glintstyne.worldgen;

import com.google.common.collect.ImmutableList;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.Random;

public final class GlintConfiguredFeatures {
  private GlintConfiguredFeatures() {}
  public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
    final RuleTest stoneTargets = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    final RuleTest deepslateTargets = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    final Random rand = new Random();
    final ImmutableList<OreConfiguration.TargetBlockState> mochiteOres = ImmutableList.of(
      OreConfiguration.target(stoneTargets, GlintBlocks.MOCHITE_ORE.get().defaultBlockState()),
      OreConfiguration.target(deepslateTargets, GlintBlocks.DEEPSLATE_MOCHITE_ORE.get().defaultBlockState())
    );
    final ImmutableList<OreConfiguration.TargetBlockState> morkiteOres = ImmutableList.of(
      OreConfiguration.target(deepslateTargets, GlintBlocks.DEEPSLATE_MORKITE_ORE.get().defaultBlockState())
    );
    final ImmutableList<OreConfiguration.TargetBlockState> xpOres = ImmutableList.of(
      OreConfiguration.target(stoneTargets, GlintBlocks.XP_ORE.get().defaultBlockState()),
      OreConfiguration.target(deepslateTargets, GlintBlocks.DEEPSLATE_XP_ORE.get().defaultBlockState())
    );


    FeatureUtils.register(context, GlintOres.MOCHITE_SML.configKey, Feature.ORE,
      new OreConfiguration(mochiteOres, 4));
    FeatureUtils.register(context, GlintOres.MOCHITE_MED.configKey, Feature.ORE,
      new OreConfiguration(mochiteOres, 8));
    FeatureUtils.register(context, GlintOres.MOCHITE_LRG.configKey, Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(16, 3, 3, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(newThresholdProvider(rand.nextLong(),
          new NormalNoise.NoiseParameters(-3, 1.0D),1.0F, 0.2F, 0.9F,
          GlintBlocks.ROUGH_MOCHITE_BLOCK.get().defaultBlockState(),
          ImmutableList.of(Blocks.CALCITE.defaultBlockState()),
          ImmutableList.of(
            GlintBlocks.MOCHITE_ORE.get().defaultBlockState(),
            GlintBlocks.DEEPSLATE_MOCHITE_ORE.get().defaultBlockState()
          )
        )), BlockPredicate.anyOf(
          BlockPredicate.matchesTag(BlockTags.STONE_ORE_REPLACEABLES),
          BlockPredicate.matchesTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
        )
      ))
    );

    FeatureUtils.register(context, GlintOres.MORKITE_SML.configKey, Feature.ORE,
      new OreConfiguration(morkiteOres, 3));
    FeatureUtils.register(context, GlintOres.MORKITE_MED.configKey, Feature.ORE,
      new OreConfiguration(morkiteOres, 6));
    FeatureUtils.register(context, GlintOres.MORKITE_LRG.configKey, Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(16, 3, 3, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(newThresholdProvider(rand.nextLong(),
          new NormalNoise.NoiseParameters(-3, 1.0D),1.0F, 0.2F, 0.9F,
          GlintBlocks.ROUGH_MORKITE_BLOCK.get().defaultBlockState(),
          ImmutableList.of(Blocks.OBSIDIAN.defaultBlockState(), Blocks.BLACKSTONE.defaultBlockState()),
          ImmutableList.of(Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState(), GlintBlocks.DEEPSLATE_MORKITE_ORE.get().defaultBlockState())
        )), BlockPredicate.anyOf(BlockPredicate.matchesTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
        )
      ))
    );

    FeatureUtils.register(context, GlintOres.XP_SML.configKey, Feature.ORE,
      new OreConfiguration(xpOres, 5));
    FeatureUtils.register(context, GlintOres.XP_MED.configKey, Feature.ORE,
      new OreConfiguration(xpOres, 8));
    FeatureUtils.register(context, GlintOres.XP_LRG.configKey, Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(16, 3, 3, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(newThresholdProvider(rand.nextLong(),
          new NormalNoise.NoiseParameters(-3, 1.0D),1.0F, 0.2F, 0.9F,
          Blocks.SCULK.defaultBlockState(),
          ImmutableList.of(Blocks.COBBLED_DEEPSLATE.defaultBlockState(), Blocks.BLACKSTONE.defaultBlockState()),
          ImmutableList.of(GlintBlocks.XP_ORE.get().defaultBlockState())
        )), BlockPredicate.anyOf(BlockPredicate.matchesTag(BlockTags.STONE_ORE_REPLACEABLES)
        )
      ))
    );

    FeatureUtils.register(context, GlintOres.ANCIENT_SML.configKey, Feature.ORE,
      new OreConfiguration(deepslateTargets, GlintBlocks.DEEPSLATE_ANCIENT_ORE.get().defaultBlockState(),
        3, 0.1F));
    FeatureUtils.register(context, GlintOres.ANCIENT_MED.configKey, Feature.ORE,
      new OreConfiguration(deepslateTargets, GlintBlocks.DEEPSLATE_ANCIENT_ORE.get().defaultBlockState(),
        6, 0.25F));
    FeatureUtils.register(context, GlintOres.ANCIENT_LRG.configKey, Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(12, 2, 2, PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(newThresholdProvider(rand.nextLong(),
          new NormalNoise.NoiseParameters(-3, 1.0D),1.0F, 0.2F, 0.75F,
          Blocks.OBSIDIAN.defaultBlockState(),
          ImmutableList.of(
            Blocks.COBBLED_DEEPSLATE.defaultBlockState(),
            Blocks.OBSIDIAN.defaultBlockState()
          ),
          ImmutableList.of(
            Blocks.OBSIDIAN.defaultBlockState(),
            GlintBlocks.DEEPSLATE_ANCIENT_ORE.get().defaultBlockState(),
            Blocks.ANCIENT_DEBRIS.defaultBlockState())
        )), BlockPredicate.anyOf(BlockPredicate.matchesTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
        )
      ))
    );
  }

  private static NoiseThresholdProvider newThresholdProvider(
    long seed, NormalNoise.NoiseParameters noise, float scale, float threshold, float highChance,
    BlockState fallback, ImmutableList<BlockState> lowState, ImmutableList<BlockState> highState
    ) {
    return new NoiseThresholdProvider(seed, noise, scale, threshold, highChance, fallback, lowState, highState);
  }
}
