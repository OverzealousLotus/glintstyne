package com.overzealouslotus.glintstyne.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class GlintPlacedFeatures {
  public static final ResourceKey<PlacedFeature> ORE_MOCHITE_SML = FeatureTools.placementKey("ore_mochite_sml");
  public static final ResourceKey<PlacedFeature> ORE_MOCHITE_LRG = FeatureTools.placementKey("ore_mochite_lrg");
  public static final ResourceKey<PlacedFeature> ORE_MORKITE_SML = FeatureTools.placementKey("ore_morkite_sml");
  public static final ResourceKey<PlacedFeature> ORE_MORKITE_LRG = FeatureTools.placementKey("ore_morkite_lrg");


  public static void bootstrap(BootstapContext<PlacedFeature> context) {
    HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


    FeatureTools.newPlacement(context, ORE_MOCHITE_SML, configuredFeatures.getOrThrow(GlintConfiguredFeatures.ORE_MOCHITE_SML),
        GlintOrePlacement.commonOrePlacement(12, // Veins per chunk
            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.belowTop(90))
        )
    );
    FeatureTools.newPlacement(context, ORE_MOCHITE_LRG, configuredFeatures.getOrThrow(GlintConfiguredFeatures.ORE_MOCHITE_LRG),
      GlintOrePlacement.commonOrePlacement(7, // Veins per chunk
        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(140))
      )
    );

    FeatureTools.newPlacement(context, ORE_MORKITE_SML, configuredFeatures.getOrThrow(GlintConfiguredFeatures.ORE_MORKITE_SML),
      GlintOrePlacement.commonOrePlacement(7, // Veins per chunk
        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(90))
      )
    );
    FeatureTools.newPlacement(context, ORE_MORKITE_LRG, configuredFeatures.getOrThrow(GlintConfiguredFeatures.ORE_MORKITE_LRG),
      List.of(NoiseBasedCountPlacement.of(50, 100, -0.5), InSquarePlacement.spread(),
        NoiseBasedCountPlacement.of(1, 5, -0.5), BiomeFilter.biome(), CountOnEveryLayerPlacement.of(7)
    ));
  }
}
