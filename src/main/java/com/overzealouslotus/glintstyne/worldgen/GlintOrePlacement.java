package com.overzealouslotus.glintstyne.worldgen;

import com.overzealouslotus.glintstyne.worldgen.placement.GlintPlacement;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class GlintOrePlacement {
  public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
    return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
  }

  public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
    return orePlacement(CountPlacement.of(pCount), pHeightRange);
  }

  public static List<PlacementModifier> glintOrePlacement(int count, PlacementModifier heightRange) {
    return orePlacement(GlintPlacement.of(count), heightRange);
  }

  public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
    return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
  }
}
