package com.overzealouslotus.glintstyne.block.custom;

import com.overzealouslotus.glintstyne.block.GlintBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Geyser extends BaseEntityBlock {
  public Geyser(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
    return RenderShape.MODEL;
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
    return new GeyserBlockEntity(blockPos, blockState);
  }

  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    if(pLevel.isClientSide()) return null;

    return createTickerHelper(pBlockEntityType, GlintBlockEntities.GEYSER_BLOCK_ENTITY.get(),
      (pLevel1, pPos, pState1, pBlockEntity) ->
        pBlockEntity.tick(pLevel1, pPos, pState1));
  }
}
