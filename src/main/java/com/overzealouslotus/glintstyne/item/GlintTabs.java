package com.overzealouslotus.glintstyne.item;

import com.google.common.collect.ImmutableSet;
import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class GlintTabs {
  public static final DeferredRegister<CreativeModeTab> GLINT_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Glintstyne.MOD_ID);
  private static final Supplier<ImmutableSet<ItemStack>> CREATIVE_ITEMS = () -> ImmutableSet.of(
    GlintItems.RAW_MOCHITE,
    GlintItems.MOCHITE,

    GlintItems.MORKITE
  ).stream().map(item -> item.get().getDefaultInstance())
    .collect(ImmutableSet.toImmutableSet());
  private static final Supplier<ImmutableSet<ItemStack>> CREATIVE_BLOCKS = () -> ImmutableSet.of(
    GlintBlocks.MOCHITE_ORE,
    GlintBlocks.DEEPSLATE_MOCHITE_ORE,
    GlintBlocks.RAW_MOCHITE_BLOCK,
    GlintBlocks.MOCHITE_BLOCK,

    GlintBlocks.DEEPSLATE_MORKITE_ORE
  ).stream().map(block -> block.get().asItem().getDefaultInstance())
    .collect(ImmutableSet.toImmutableSet());

  public static final RegistryObject<CreativeModeTab> GLINTSTYNE_TAB =
    GLINT_TABS.register("glintstyne_tab", () -> CreativeModeTab.builder()
      .icon(() -> new ItemStack(GlintItems.MOCHITE.get()))
      .title(Component.translatable("creativetab.glintstyne_tab"))
      .displayItems(((itemDisplayParameters, output) -> {
        output.acceptAll(CREATIVE_ITEMS.get());
        output.acceptAll(CREATIVE_BLOCKS.get());
      })).build());

  public static void register(IEventBus eventBus) {
    GLINT_TABS.register(eventBus);
  }
}