package com.overzealouslotus.glintstyne.datagen.dynamic;

import com.google.gson.JsonElement;
import com.overzealouslotus.glintstyne.Glintstyne;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.mehvahdjukaar.moonlight.api.resources.RPUtils;
import net.mehvahdjukaar.moonlight.api.resources.ResType;
import net.mehvahdjukaar.moonlight.api.resources.pack.DynServerResourcesGenerator;
import net.mehvahdjukaar.moonlight.api.resources.pack.DynamicDataPack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.resources.ResourceManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class GlintDynamics extends DynServerResourcesGenerator {
  public static final GlintDynamics INSTANCE = new GlintDynamics();
  protected GlintDynamics() {
    super(new DynamicDataPack(Glintstyne.id("generated_pack"), Pack.Position.TOP, true, false));
    this.dynamicPack.addNamespaces("glintstyne");
  }

  @Override
  public Logger getLogger() {
    return Glintstyne.LOGGER;
  }

  @Override
  public boolean dependsOnLoadedPacks() {
    return true;
  }

  public void writeDataFile(ResourceManager manager, List<String> list, String targetNamespace, String targetPath, String sourcePath, ResType resType) {
    for (var recipe : list) {
      final ResourceLocation target = ResourceLocation.fromNamespaceAndPath(
        targetNamespace, targetPath + recipe
      );
      final ResourceLocation source = ResourceLocation.fromNamespaceAndPath(
        "glintstyne", sourcePath + recipe + ".json"
      );

      try (var bsStream = manager.getResource(source).orElseThrow().open()) {
        JsonElement bsElement = RPUtils.deserializeJson(bsStream);
        dynamicPack.addJson(target, bsElement, resType);

      } catch (Exception ignored) {
      }
    }
  }

  @Override
  public void regenerateDynamicAssets(ResourceManager resourceManager) {
    /* if(PlatHelper.isModLoaded("spelunkery")) {
      List<String> debug = List.of("deepslate_morkite_ore");
      writeDataFile(resourceManager, debug,
        "glintstyne", "",
        "overrides/loot_tables/", ResType.BLOCK_LOOT_TABLES);
    } */

  }
}
