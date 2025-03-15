package com.overzealouslotus.glintstyne.datagen;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.item.GlintItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(Glintstyne.MOD_ID, "item/" + item.getId().getPath()));
    }
}
