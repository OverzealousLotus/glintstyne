package com.overzealouslotus.glintstyne.worldgen.util;

import com.google.common.collect.ImmutableList;
import com.overzealouslotus.glintstyne.worldgen.placement.GlintPlacement;
import net.minecraft.world.level.levelgen.placement.*;

public final class OreUtils {
  public static ImmutableList<PlacementModifier> genericPlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
    return ImmutableList.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
  }

  /**
   * @param count How many veins will occur each chunk.
   * @param heightRange Range where veins are generated.
   */
  public static ImmutableList<PlacementModifier> commonPlacement(int count, PlacementModifier heightRange) {
    return genericPlacement(CountPlacement.of(count), heightRange);
  }

  static ImmutableList<PlacementModifier> glintOrePlacement(int count, PlacementModifier heightRange) {
    return genericPlacement(GlintPlacement.of(count), heightRange);
  }

  /**
   * @param chance Chance decided by: ( 1 / chance )
   * @param heightRange Range where veins are generated.
   */
  public static ImmutableList<PlacementModifier> rarityPlacement(int chance, PlacementModifier heightRange) {
    return genericPlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
  }

  static ImmutableList<PlacementModifier> noiseOrePlacement(int ratio, double factor, double offset, PlacementModifier heightRange) {
    return genericPlacement(NoiseBasedCountPlacement.of(ratio, factor, offset), heightRange);
  }
}
