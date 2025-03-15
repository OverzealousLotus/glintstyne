package com.overzealouslotus.glintstyne.worldgen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import com.overzealouslotus.glintstyne.config.GlintConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class GlintConfiguredFeatures {

  public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MOCHITE_ORE = registerKey("mochite_ore");

  public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
    RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    List<OreConfiguration.TargetBlockState> overworldMochiteOres = List.of(
        OreConfiguration.target(stoneReplaceables, GlintBlocks.MOCHITE_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, GlintBlocks.DEEPSLATE_MOCHITE_ORE.get().defaultBlockState())
    );

    // size: Vein Size
    register(context, OVERWORLD_MOCHITE_ORE, Feature.ORE,
        new OreConfiguration(overworldMochiteOres, 7));
  }
  public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
    return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Glintstyne.MOD_ID, name));
  }

  private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                        ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }
}
