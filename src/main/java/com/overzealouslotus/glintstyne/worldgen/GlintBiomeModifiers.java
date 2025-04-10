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

    overworldOre(context, biomes, placedFeatures, GlintOres.MOCHITE_SML.modifierKey, GlintOres.MOCHITE_SML.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.MOCHITE_MED.modifierKey, GlintOres.MOCHITE_MED.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.MOCHITE_LRG.modifierKey, GlintOres.MOCHITE_LRG.placementKey);

    overworldOre(context, biomes, placedFeatures, GlintOres.MORKITE_SML.modifierKey, GlintOres.MORKITE_SML.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.MORKITE_MED.modifierKey, GlintOres.MORKITE_MED.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.MORKITE_LRG.modifierKey, GlintOres.MORKITE_LRG.placementKey);

    overworldOre(context, biomes, placedFeatures, GlintOres.XP_SML.modifierKey, GlintOres.XP_SML.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.XP_MED.modifierKey, GlintOres.XP_MED.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.XP_LRG.modifierKey, GlintOres.XP_LRG.placementKey);

    overworldOre(context, biomes, placedFeatures, GlintOres.ANCIENT_SML.modifierKey, GlintOres.ANCIENT_SML.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.ANCIENT_MED.modifierKey, GlintOres.ANCIENT_MED.placementKey);
    overworldOre(context, biomes, placedFeatures, GlintOres.ANCIENT_LRG.modifierKey, GlintOres.ANCIENT_LRG.placementKey);
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
