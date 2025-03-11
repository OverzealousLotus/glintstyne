package com.overzealouslotus.glintstyne.datagen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GlintTagProvider extends BlockTagsProvider {

    public GlintTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Glintstyne.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Blocks.ORES)
            .add(GlintBlocks.MOCHITE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(GlintBlocks.MOCHITE_BLOCK.get())
            .add(GlintBlocks.RAW_MOCHITE_BLOCK.get())
            .add(GlintBlocks.MOCHITE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(GlintBlocks.MOCHITE_BLOCK.get())
            .add(GlintBlocks.RAW_MOCHITE_BLOCK.get())
            .add(GlintBlocks.MOCHITE_ORE.get());
    }
}
