package com.overzealouslotus.glintstyne.datagen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.worldgen.GlintBiomeModifiers;
import com.overzealouslotus.glintstyne.worldgen.GlintConfiguredFeatures;
import com.overzealouslotus.glintstyne.worldgen.GlintPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GlintWorldGenProvider extends DatapackBuiltinEntriesProvider {
  public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
      .add(Registries.CONFIGURED_FEATURE, GlintConfiguredFeatures::bootstrap)
      .add(Registries.PLACED_FEATURE, GlintPlacedFeatures::bootstrap)
      .add(ForgeRegistries.Keys.BIOME_MODIFIERS, GlintBiomeModifiers::bootstrap);

  public GlintWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
    super(output, registries, BUILDER, Set.of(Glintstyne.MOD_ID));
  }
}
