package com.overzealouslotus.glintstyne.worldgen;

import com.overzealouslotus.glintstyne.Glintstyne;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class FeatureTools {
  protected static ResourceKey<ConfiguredFeature<?, ?>> configKey(String name) {
    return ResourceKey.create(Registries.CONFIGURED_FEATURE, Glintstyne.id(name));
  }

  protected static <FC extends FeatureConfiguration, F extends Feature<FC>> void newConfig(
    BootstapContext<ConfiguredFeature<?, ?>> context,
    ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration
  ) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }

  protected static ResourceKey<PlacedFeature> placementKey(String name) {
    return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Glintstyne.MOD_ID, name));
  }

  protected static void newPlacement(
    BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
    Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers
  ) {
    context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
  }
}
