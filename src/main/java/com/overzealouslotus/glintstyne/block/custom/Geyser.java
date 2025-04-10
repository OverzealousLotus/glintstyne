package com.overzealouslotus.glintstyne.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class Geyser extends InertGeyserBlock {
  public static final int GROWTH_CHANCE = 5;
  private static final Direction[] DIRECTIONS = Direction.values();

  public Geyser(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public void randomTick(BlockState myState, ServerLevel level, BlockPos myPosition, RandomSource pRandom) {
    if (pRandom.nextInt(5) == 0) {
      Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
      BlockPos targetPosition = myPosition.offset(new Vec3i(
        pRandom.nextIntBetweenInclusive(-2, 2),
        pRandom.nextIntBetweenInclusive(1, 3),
        pRandom.nextIntBetweenInclusive(-2, 2)
      ));
      BlockState targetState = level.getBlockState(targetPosition);
      Optional<Block> futureBlock = Optional.empty();
      if (BuddingAmethystBlock.canClusterGrowAtState(targetState)) {
        futureBlock = Optional.of(Blocks.RAW_IRON_BLOCK);
      }

      if (futureBlock.isPresent()) {
        BlockState newState = futureBlock.get().defaultBlockState();
        level.setBlockAndUpdate(targetPosition, newState);
      }
    }
  }
}
