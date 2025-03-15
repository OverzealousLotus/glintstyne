package com.overzealouslotus.glintstyne.config;

import com.overzealouslotus.glintstyne.Glintstyne;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Glintstyne.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlintConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.IntValue MIN_LAVA_LEVEL = BUILDER
        .comment(" Set lava level.")
        .comment(" Default: -54 (vanilla)")
        .comment(" Will not change level for old chunks.")
        .defineInRange("minLavaLevel", -54, -4096, 4096);

    public static Integer minLavaLevel;
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        minLavaLevel = MIN_LAVA_LEVEL.get();
    }
}
