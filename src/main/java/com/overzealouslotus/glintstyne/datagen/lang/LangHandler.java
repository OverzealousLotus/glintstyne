package com.overzealouslotus.glintstyne.datagen.lang;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import com.overzealouslotus.glintstyne.item.GlintItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public final class LangHandler extends LanguageProvider {
  public LangHandler(PackOutput output, String locale) {
    super(output, Glintstyne.MOD_ID, locale);
  }

  @Override
  protected void addTranslations() {
    this.addBlock(GlintBlocks.DEEPSLATE_ANCIENT_ORE, "Deepslate Ancient Ore");
    this.addBlock(GlintBlocks.DEEPSLATE_MOCHITE_ORE, "Deepslate Mochite Ore");
    this.addBlock(GlintBlocks.DEEPSLATE_MORKITE_ORE, "Deepslate Morkite Ore");
    this.addBlock(GlintBlocks.MOCHITE_ORE, "Mochite Ore");
    this.addBlock(GlintBlocks.ROUGH_MOCHITE_BLOCK, "Block of Rough Mochite");
    this.addBlock(GlintBlocks.ROUGH_MORKITE_BLOCK, "Block of Rough Morkite");
    this.addBlock(GlintBlocks.MOCHITE_BLOCK, "Block of Mochite");
    this.addBlock(GlintBlocks.DEEPSLATE_XP_ORE, "Deepslate Experience Ore");
    this.addBlock(GlintBlocks.XP_ORE, "Experience Ore");
    this.addBlock(GlintBlocks.NEFARIUM_ORE, "Nefarium Ore");

    this.addItem(GlintItems.SMALL_ANCIENT_SHARD, "Small Ancient Shard");
    this.addItem(GlintItems.LARGE_ANCIENT_SHARD, "Large Ancient Shard");
    this.addItem(GlintItems.RAW_MOCHITE, "Rough Mochite");
    this.addItem(GlintItems.MOCHITE, "Mochite");
    this.addItem(GlintItems.MORKITE, "Morkite");

    this.add("creativetab.glintstyne", "Glintstyne");
  }
}
