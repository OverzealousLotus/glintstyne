package com.overzealouslotus.glintstyne.block;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.custom.GeyserBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GlintBlockEntities {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
    DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Glintstyne.MOD_ID);


  public static final RegistryObject<BlockEntityType<GeyserBlockEntity>> GEYSER_BLOCK_ENTITY =
    BLOCK_ENTITIES.register("geyser_block_entity", () ->
      BlockEntityType.Builder.of(GeyserBlockEntity::new,
        GlintBlocks.NEFARIUM_ORE.get()).build(null));

  public static void registerBlockEntities(IEventBus bus) {
    BLOCK_ENTITIES.register(bus);
  }
}
