package com.overzealouslotus.glintstyne.datagen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class GlintBlockStateProvider extends BlockStateProvider {
    public GlintBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Glintstyne.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(GlintBlocks.MOCHITE_BLOCK);
        blockWithItem(GlintBlocks.ROUGH_MOCHITE_BLOCK);
        blockWithItem(GlintBlocks.MOCHITE_ORE);
        blockWithItem(GlintBlocks.DEEPSLATE_MOCHITE_ORE);
        blockWithItem(GlintBlocks.DEEPSLATE_MORKITE_ORE);
        blockWithItem(GlintBlocks.ROUGH_MORKITE_BLOCK);
        blockWithItem(GlintBlocks.XP_ORE);
        blockWithItem(GlintBlocks.DEEPSLATE_XP_ORE);
        blockWithItem(GlintBlocks.DEEPSLATE_ANCIENT_ORE);
        blockWithItem(GlintBlocks.NEFARIUM_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
