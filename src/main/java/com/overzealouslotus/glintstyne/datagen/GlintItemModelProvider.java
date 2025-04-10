package com.overzealouslotus.glintstyne.datagen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.item.GlintItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class GlintItemModelProvider extends ItemModelProvider {
    public GlintItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Glintstyne.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(GlintItems.MOCHITE);
        simpleItem(GlintItems.RAW_MOCHITE);
        simpleItem(GlintItems.MORKITE);
        simpleItem(GlintItems.SMALL_ANCIENT_SHARD);
        simpleItem(GlintItems.LARGE_ANCIENT_SHARD);
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
          ResourceLocation.parse("item/generated")).texture("layer0",
          Glintstyne.id("item/" + item.getId().getPath()));
    }
}
