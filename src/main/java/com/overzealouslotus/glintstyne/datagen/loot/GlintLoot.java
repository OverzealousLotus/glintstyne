package com.overzealouslotus.glintstyne.datagen.loot;

import com.overzealouslotus.glintstyne.block.GlintBlocks;
import com.overzealouslotus.glintstyne.item.GlintItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class GlintLoot extends BlockLootSubProvider {

    public GlintLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(GlintBlocks.MOCHITE_BLOCK.get());
        this.dropSelf(GlintBlocks.RAW_MOCHITE_BLOCK.get());

        this.add(GlintBlocks.MOCHITE_ORE.get(), block ->
            createRichOreDrops(block, GlintItems.RAW_MOCHITE.get(), 1, 3));
    }

    protected LootTable.Builder createRichOreDrops(Block pBlock, Item pItem, float min, float max) {
        return createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GlintBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
