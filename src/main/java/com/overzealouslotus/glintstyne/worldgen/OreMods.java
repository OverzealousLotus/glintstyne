package com.overzealouslotus.glintstyne.worldgen;

import com.overzealouslotus.glintstyne.Glintstyne;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class OreMods {
  protected static final ResourceKey<BiomeModifier> SML_MOCHITE = registerKey("ore_mochite_sml");
  protected static final ResourceKey<BiomeModifier> LRG_MOCHITE = registerKey("ore_mochite_lrg");

  protected static final ResourceKey<BiomeModifier> SML_MORKITE = registerKey("ore_morkite_sml");
  protected static final ResourceKey<BiomeModifier> LRG_MORKITE = registerKey("ore_morkite_lrg");

  private static ResourceKey<BiomeModifier> registerKey(String name) {
    return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, Glintstyne.id(name));
  }
}
