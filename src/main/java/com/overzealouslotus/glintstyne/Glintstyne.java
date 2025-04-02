package com.overzealouslotus.glintstyne;

import com.overzealouslotus.glintstyne.block.GlintBlocks;
import com.overzealouslotus.glintstyne.config.GlintConfig;
import com.overzealouslotus.glintstyne.datagen.dynamic.GlintDynamics;
import com.overzealouslotus.glintstyne.item.GlintItems;
import com.overzealouslotus.glintstyne.item.GlintTabs;
import com.overzealouslotus.glintstyne.worldgen.placement.GlintPlacementModifierTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Glintstyne.MOD_ID)
public class Glintstyne {
    public static final String MOD_ID = "glintstyne";
    public static final Logger LOGGER = LogManager.getLogger();

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public Glintstyne(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        context.registerConfig(ModConfig.Type.COMMON, GlintConfig.SPEC);

        GlintPlacementModifierTypes.PLACEMENT_MODIFIER_TYPES.register(modEventBus);
        GlintItems.register(modEventBus);
        GlintBlocks.register(modEventBus);
        GlintTabs.register(modEventBus);
        GlintDynamics.INSTANCE.register();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
