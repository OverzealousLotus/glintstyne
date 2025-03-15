package com.overzealouslotus.glintstyne.worldgen.placement;

import com.overzealouslotus.glintstyne.Glintstyne;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GlintPlacementModifierTypes {
  public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPES =
      DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, Glintstyne.MOD_ID);

  public static final RegistryObject<PlacementModifierType<GlintPlacement>> GLINT_PLACEMENT =
      PLACEMENT_MODIFIER_TYPES.register("glint_placement", () -> () -> GlintPlacement.CODEC);
}
