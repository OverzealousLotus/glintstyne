package com.overzealouslotus.glintstyne.item;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GlintTabs {
    public static final DeferredRegister<CreativeModeTab> GLINT_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Glintstyne.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GLINTSTYNE_TAB =
        GLINT_TABS.register("glintstyne_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(GlintItems.MOCHITE.get()))
            .title(Component.translatable("creativetab.glintstyne_tab"))
            .displayItems(((itemDisplayParameters, output) -> {
                output.accept(GlintItems.RAW_MOCHITE.get());
                output.accept(GlintItems.MOCHITE.get());
                output.accept(GlintBlocks.MOCHITE_BLOCK.get());
                output.accept(GlintBlocks.RAW_MOCHITE_BLOCK.get());
                output.accept(GlintBlocks.MOCHITE_ORE.get());
            })).build());

    public static void register(IEventBus eventBus) {
        GLINT_TABS.register(eventBus);
    }
}
