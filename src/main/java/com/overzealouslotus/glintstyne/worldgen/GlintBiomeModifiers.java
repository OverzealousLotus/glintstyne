package com.overzealouslotus.glintstyne.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;

public final class GlintBiomeModifiers {
  public static void bootstrap(BootstapContext<BiomeModifier> context) {
    final HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
    final HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

    overworldOre(context, biomes, placedFeatures, OreMods.SML_MOCHITE, GlintPlacedFeatures.ORE_MOCHITE_SML);
    overworldOre(context, biomes, placedFeatures, OreMods.LRG_MOCHITE, GlintPlacedFeatures.ORE_MOCHITE_LRG);

    overworldOre(context, biomes, placedFeatures, OreMods.SML_MORKITE, GlintPlacedFeatures.ORE_MORKITE_SML);
    overworldOre(context, biomes, placedFeatures, OreMods.LRG_MORKITE, GlintPlacedFeatures.ORE_MORKITE_LRG);
  }

  private static void overworldOre(
    BootstapContext<BiomeModifier> context, HolderGetter<Biome> biomes, HolderGetter<PlacedFeature> features,
    ResourceKey<BiomeModifier> name, ResourceKey<PlacedFeature> feature
  ) {
    context.register(name, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
      biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
      HolderSet.direct(features.getOrThrow(feature)),
      GenerationStep.Decoration.UNDERGROUND_ORES
    ));
  }
}
