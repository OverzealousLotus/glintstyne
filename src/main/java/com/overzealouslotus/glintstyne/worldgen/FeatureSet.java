package com.overzealouslotus.glintstyne.worldgen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;

public final class FeatureSet {
  final ResourceKey<ConfiguredFeature<?, ?>> configKey;
  final ResourceKey<PlacedFeature> placementKey;
  final ResourceKey<BiomeModifier> modifierKey;

  private FeatureSet(String name) {
   this.configKey = FeatureTools.configKey(name);
   this.placementKey = FeatureTools.placementKey(name);
   this.modifierKey = FeatureTools.modifierKey(name);
  }

  static FeatureSet of(String name) {
    return new FeatureSet(name);
  }
}
