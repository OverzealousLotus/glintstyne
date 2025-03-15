package com.overzealouslotus.glintstyne.datagen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.datagen.loot.GlintLootProvider;
import com.overzealouslotus.glintstyne.datagen.tag.ItemTagHandler;
import com.overzealouslotus.glintstyne.datagen.tag.BlockTagHandler;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Glintstyne.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new GlintRecipeProvider(output));
        generator.addProvider(event.includeServer(), GlintLootProvider.create(output));

        generator.addProvider(event.includeClient(), new GlintBlockStateProvider(output, helper));
        generator.addProvider(event.includeServer(), new GlintItemModelProvider(output, helper));

        BlockTagHandler tagProvider = generator.addProvider(event.includeServer(),
            new BlockTagHandler(output, provider, helper));
        generator.addProvider(event.includeServer(), new ItemTagHandler(output, provider, tagProvider.contentsGetter(), helper));

        generator.addProvider(event.includeServer(), new GlintWorldGenProvider(output, provider));
    }
}
