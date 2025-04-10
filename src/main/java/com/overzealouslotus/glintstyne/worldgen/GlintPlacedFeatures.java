package com.overzealouslotus.glintstyne.worldgen;

import com.google.common.collect.ImmutableList;
import com.overzealouslotus.glintstyne.worldgen.util.OreUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public final class GlintPlacedFeatures {
  public static void bootstrap(BootstapContext<PlacedFeature> context) {
    HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

    PlacementUtils.register(context, GlintOres.MOCHITE_SML.placementKey,
      configuredFeatures.getOrThrow(GlintOres.MOCHITE_SML.configKey),
      OreUtils.commonPlacement(12,
          HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.belowTop(90))
      )
    );
    PlacementUtils.register(context, GlintOres.MOCHITE_MED.placementKey,
      configuredFeatures.getOrThrow(GlintOres.MOCHITE_MED.configKey),
      OreUtils.commonPlacement(7,
        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(140))
      )
    );
    PlacementUtils.register(context, GlintOres.MOCHITE_LRG.placementKey,
      configuredFeatures.getOrThrow(GlintOres.MOCHITE_LRG.configKey),
      ImmutableList.of(NoiseBasedCountPlacement.of(50, 100, -0.5), InSquarePlacement.spread(),
        NoiseBasedCountPlacement.of(1, 5, -0.5), BiomeFilter.biome(),
        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(48), VerticalAnchor.absolute(32))
      )
    );

    PlacementUtils.register(context, GlintOres.MORKITE_SML.placementKey,
      configuredFeatures.getOrThrow(GlintOres.MORKITE_SML.configKey),
      OreUtils.commonPlacement(7,
        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(90))
      )
    );
    PlacementUtils.register(context, GlintOres.MORKITE_MED.placementKey,
      configuredFeatures.getOrThrow(GlintOres.MORKITE_MED.configKey),
      OreUtils.rarityPlacement(20,
        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(90))
      )
    );
    PlacementUtils.register(context, GlintOres.MORKITE_LRG.placementKey,
      configuredFeatures.getOrThrow(GlintOres.MORKITE_LRG.configKey),
      ImmutableList.of(NoiseBasedCountPlacement.of(50, 100, -0.5), InSquarePlacement.spread(),
        NoiseBasedCountPlacement.of(1, 5, -0.5), BiomeFilter.biome(),
        HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64))
      )
    );

    PlacementUtils.register(context, GlintOres.XP_SML.placementKey,
      configuredFeatures.getOrThrow(GlintOres.XP_SML.configKey),
      OreUtils.commonPlacement(9,
        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())
      )
    );
    PlacementUtils.register(context, GlintOres.XP_MED.placementKey,
      configuredFeatures.getOrThrow(GlintOres.XP_MED.configKey),
      OreUtils.rarityPlacement(14,
        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())
      )
    );
    PlacementUtils.register(context, GlintOres.XP_LRG.placementKey,
      configuredFeatures.getOrThrow(GlintOres.XP_LRG.configKey),
      ImmutableList.of(NoiseBasedCountPlacement.of(50, 100, -0.5), InSquarePlacement.spread(),
        NoiseBasedCountPlacement.of(1, 5, -0.5), BiomeFilter.biome(),
        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.top())
      )
    );

    PlacementUtils.register(context, GlintOres.ANCIENT_SML.placementKey,
      configuredFeatures.getOrThrow(GlintOres.ANCIENT_SML.configKey),
      OreUtils.rarityPlacement(3,
        HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64))
      )
    );
    PlacementUtils.register(context, GlintOres.ANCIENT_MED.placementKey,
      configuredFeatures.getOrThrow(GlintOres.ANCIENT_MED.configKey),
      OreUtils.rarityPlacement(10,
        HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64))
      )
    );
    PlacementUtils.register(context, GlintOres.ANCIENT_LRG.placementKey,
      configuredFeatures.getOrThrow(GlintOres.ANCIENT_LRG.configKey),
      ImmutableList.of(NoiseBasedCountPlacement.of(50, 100, -0.5), InSquarePlacement.spread(),
        NoiseBasedCountPlacement.of(1, 5, -0.5), BiomeFilter.biome(),
        HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64))
      )
    );
  }
}
