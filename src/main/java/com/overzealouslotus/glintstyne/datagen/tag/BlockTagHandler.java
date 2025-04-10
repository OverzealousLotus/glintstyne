package com.overzealouslotus.glintstyne.datagen.tag;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public final class BlockTagHandler extends BlockTagsProvider {

  public BlockTagHandler(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, Glintstyne.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.@NotNull Provider provider) {
    this.tag(Tags.Blocks.ORES).add(
      GlintBlocks.MOCHITE_ORE.get(),
      GlintBlocks.DEEPSLATE_MOCHITE_ORE.get(),
      GlintBlocks.DEEPSLATE_MORKITE_ORE.get(),
      GlintBlocks.XP_ORE.get(),
      GlintBlocks.DEEPSLATE_XP_ORE.get(),
      GlintBlocks.DEEPSLATE_ANCIENT_ORE.get()
    );

    this.tag(BlockTags.NEEDS_IRON_TOOL).add(
      GlintBlocks.MOCHITE_ORE.get(),
      GlintBlocks.DEEPSLATE_MOCHITE_ORE.get(),
      GlintBlocks.ROUGH_MOCHITE_BLOCK.get(),
      GlintBlocks.MOCHITE_BLOCK.get(),
      GlintBlocks.XP_ORE.get(),
      GlintBlocks.DEEPSLATE_XP_ORE.get()
    );

    this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
      GlintBlocks.DEEPSLATE_MORKITE_ORE.get(),
      GlintBlocks.ROUGH_MORKITE_BLOCK.get(),
      GlintBlocks.DEEPSLATE_ANCIENT_ORE.get()
    );

    this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
      GlintBlocks.MOCHITE_ORE.get(),
      GlintBlocks.DEEPSLATE_MOCHITE_ORE.get(),
      GlintBlocks.ROUGH_MOCHITE_BLOCK.get(),
      GlintBlocks.MOCHITE_BLOCK.get(),

      GlintBlocks.DEEPSLATE_MORKITE_ORE.get(),
      GlintBlocks.ROUGH_MORKITE_BLOCK.get(),

      GlintBlocks.XP_ORE.get(),
      GlintBlocks.DEEPSLATE_XP_ORE.get(),

      GlintBlocks.DEEPSLATE_MORKITE_ORE.get(),

      GlintBlocks.DEEPSLATE_ANCIENT_ORE.get()
    );
  }
}
