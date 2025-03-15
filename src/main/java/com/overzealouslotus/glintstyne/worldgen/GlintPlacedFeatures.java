package com.overzealouslotus.glintstyne.worldgen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.config.GlintConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class GlintPlacedFeatures {
  public static final ResourceKey<PlacedFeature> MOCHITE_ORE_PLACED = registerKey("mochite_ore_placed");


  public static void bootstrap(BootstapContext<PlacedFeature> context) {
    HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


    register(context, MOCHITE_ORE_PLACED, configuredFeatures.getOrThrow(GlintConfiguredFeatures.OVERWORLD_MOCHITE_ORE),
        GlintOrePlacement.commonOrePlacement(12, // Veins per chunk
            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.belowTop(90))
        )
    );
  }







  private static ResourceKey<PlacedFeature> registerKey(String name) {
    return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Glintstyne.MOD_ID, name));
  }

  private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                               List<PlacementModifier> modifiers) {
    context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
  }
}
