package com.overzealouslotus.glintstyne.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public final class FuelItem extends Item {
  private final int burnTime;

  public FuelItem(Properties pProperties, int burnTime) {
    super(pProperties);
    this.burnTime = burnTime;
  }

  @Override
  public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
    return this.burnTime;
  }
}
