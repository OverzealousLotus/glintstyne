package com.overzealouslotus.glintstyne.worldgen;

import com.overzealouslotus.glintstyne.Glintstyne;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public final class FeatureTools {
  static ResourceKey<ConfiguredFeature<?, ?>> configKey(String name) {
    return ResourceKey.create(Registries.CONFIGURED_FEATURE, Glintstyne.id(name));
  }
  static ResourceKey<PlacedFeature> placementKey(String name) {
    return ResourceKey.create(Registries.PLACED_FEATURE, Glintstyne.id(name));
  }
  static ResourceKey<BiomeModifier> modifierKey(String name) {
    return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, Glintstyne.id(name));
  }
}
