package com.overzealouslotus.glintstyne.config;

import com.overzealouslotus.glintstyne.Glintstyne;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Glintstyne.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class GlintConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.IntValue MIN_LAVA_LEVEL = BUILDER
        .comment(" Set lava level.")
        .comment(" Default: -54 (vanilla)")
        .comment(" Will not change level for old chunks.")
        .defineInRange("minLavaLevel", -54, -4096, 4096);
    private static final ForgeConfigSpec.IntValue PLACEMENT_XZ_RANGE = BUILDER
      .comment(" Set XZ range for Nefarium.")
      .comment(" Default: 1")
      .defineInRange("placementXZRange", 1, 1, 100);
    private static final ForgeConfigSpec.IntValue PLACEMENT_Y_RANGE = BUILDER
      .comment(" Set Y range for Nefarium.")
      .comment(" Default: 1")
      .defineInRange("placementYRange", 1, 1, 100);
    private static final ForgeConfigSpec.IntValue CYCLE_DURATION_MIN = BUILDER
      .comment(" Set minimum delay between cycles in ticks.")
      .comment(" Default: 100")
      .defineInRange("cycleDurationMin",  100, 100, 10000);
    private static final ForgeConfigSpec.IntValue CYCLE_DURATION_MAX = BUILDER
      .comment(" Set maximum delay between cycles in ticks.")
      .comment(" Default: 300")
      .defineInRange("cycleDurationMax", 300, 200, 10000);
    private static final ForgeConfigSpec.IntValue ERUPTION_DURATION_MIN = BUILDER
      .comment(" Set cycle length in ticks.")
      .comment(" Default: 100")
      .defineInRange("eruptionDurationMin", 100, 100, 10000);
    private static final ForgeConfigSpec.IntValue ERUPTION_DURATION_MAX = BUILDER
      .comment(" Set cycle length in ticks.")
      .comment(" Default: 300")
      .defineInRange("eruptionDurationMax", 200, 200, 10000);

    public static Integer minLavaLevel;
    public static Integer placementXZRange;
    public static Integer placementYRange;
    public static Integer cycleDurationMin;
    public static Integer cycleDurationMax;
    public static Integer eruptionLengthMin;
    public static Integer eruptionLengthMax;
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        minLavaLevel = MIN_LAVA_LEVEL.get();
        placementXZRange = PLACEMENT_XZ_RANGE.get();
        placementYRange = PLACEMENT_Y_RANGE.get();
        cycleDurationMin = CYCLE_DURATION_MIN.get();
        cycleDurationMax = CYCLE_DURATION_MAX.get();
        eruptionLengthMin = ERUPTION_DURATION_MIN.get();
        eruptionLengthMax = ERUPTION_DURATION_MAX.get();
    }
}
