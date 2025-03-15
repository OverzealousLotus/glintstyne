package com.overzealouslotus.glintstyne.worldgen.placement;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.placement.RepeatingPlacement;

public class GlintPlacement extends RepeatingPlacement {
  public static final Codec<GlintPlacement> CODEC = IntProvider.codec(0, 256)
      .fieldOf("count").xmap(GlintPlacement::new, (placement) -> placement.count).codec();
  private final IntProvider count;

  private GlintPlacement(IntProvider intProvider) {
    this.count = intProvider;
  }

  public static GlintPlacement of(IntProvider pCount) {
    return new GlintPlacement(pCount);
  }

  public static GlintPlacement of(int pCount) {
    return of(ConstantInt.of(pCount));
  }

  protected int count(RandomSource pRandom, BlockPos pPos) {
    return this.count.sample(pRandom);
  }

  public PlacementModifierType<?> type() {
    return PlacementModifierType.COUNT;
  }
}
