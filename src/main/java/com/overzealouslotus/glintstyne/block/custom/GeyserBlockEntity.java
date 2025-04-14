package com.overzealouslotus.glintstyne.block.custom;

import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlockEntities;
import com.overzealouslotus.glintstyne.config.GlintConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class GeyserBlockEntity extends BlockEntity {
  private final ContainerData data;
  private final int cycleDuration = new Random().nextInt(GlintConfig.cycleDurationMin, GlintConfig.cycleDurationMax);
  private final int originEruptionDuration = new Random().nextInt(GlintConfig.eruptionLengthMin, GlintConfig.eruptionLengthMax);
  private static final String ERUPTION_DURATION_PATH = "geyser.eruption_duration";
  private int eruptionDuration = originEruptionDuration;

  public GeyserBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(GlintBlockEntities.GEYSER_BLOCK_ENTITY.get(), pPos, pBlockState);
    this.data = new ContainerData() {
      @Override
      public int get(int i) {
        return switch (i) {
          case 0 -> GeyserBlockEntity.this.eruptionDuration;
          default -> 0;
        };
      }

      @Override
      public void set(int index, int value) {
        switch (index) {
          case 0 -> GeyserBlockEntity.this.eruptionDuration = value;
        }
      }

      @Override
      public int getCount() {
        return 1;
      }
    };
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    pTag.putInt(ERUPTION_DURATION_PATH, this.eruptionDuration);
    super.saveAdditional(pTag);
  }

  @Override
  public void load(@NotNull CompoundTag tag) {
    this.eruptionDuration = tag.getInt(ERUPTION_DURATION_PATH);
    super.load(tag);
  }

  public void tick(Level level, BlockPos myPosition, BlockState myState) {
    final long gameTime = level.getGameTime();
    setChanged(level, myPosition, myState);
    if(this.isErupting()) {
      if (this.eruptionDuration != 0) this.eruptionDuration -= 1;
      final RandomSource random = level.getRandom();
      Glintstyne.LOGGER.debug(newGaussianRange(random, -1, 1, 0.4, 0));
      final BlockPos targetPosition = nextTarget(myPosition, random);
      final BlockState targetState = level.getBlockState(targetPosition);

      if (BuddingAmethystBlock.canClusterGrowAtState(targetState) && gameTime % 20 == 0) {
        Glintstyne.LOGGER.debug("[ Duration ]: {}", this.eruptionDuration);
        BlockState newState = Blocks.RAW_COPPER_BLOCK.defaultBlockState();
        level.setBlockAndUpdate(targetPosition, newState);
        level.playSound(null, myPosition.getX(), myPosition.getY(), myPosition.getZ(),
          SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1, 1
        );
        this.erupt(myPosition, level, random);
      }
    }

    if ((gameTime % this.cycleDuration) == 0) {
      this.eruptionDuration = this.originEruptionDuration;
    }
  }

  /**
   * @return `true` if eruptionDuration is greater than 0.
   */
  public boolean isErupting() {
    return this.eruptionDuration > 0;
  }

  /**
   * @return Returns next target block.
   */
  private BlockPos nextTarget(BlockPos myPosition, RandomSource random) {
    final int inverseRange = GlintConfig.placementXZRange - (GlintConfig.placementXZRange * 2);
    return myPosition.offset(new Vec3i(
      random.nextIntBetweenInclusive(inverseRange, GlintConfig.placementXZRange),
      random.nextIntBetweenInclusive(GlintConfig.placementYRange - (GlintConfig.placementYRange * 2), GlintConfig.placementYRange),
      random.nextIntBetweenInclusive(inverseRange, GlintConfig.placementXZRange)
    ));
  }

  private void erupt(BlockPos myPosition, Level level, RandomSource random) {
    final Vec3 center = myPosition.getCenter();
    final Arrow arrow = new Arrow(level, center.x(), center.y() + 1, center.z());
    arrow.shoot(
      newGaussianRange(random, -1, 1, 0.4, 0),
      15,
      newGaussianRange(random, -1, 1, 0.4, 0),
      1.0F, 0.8F
    );
    arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
    level.addFreshEntity(arrow);
  }

  /**
   * @param deviation Offset from average?
   * @param mean Average
   * @return New `double` within constraints. If overshot, default to min/max.
   */
  private double newGaussianRange(RandomSource random, int min, int max, double deviation, double mean) {
    return Math.max(min, Math.min(max, random.nextGaussian() * deviation + mean));
  }
}