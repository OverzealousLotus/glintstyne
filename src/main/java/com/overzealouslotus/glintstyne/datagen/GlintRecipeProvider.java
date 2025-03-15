package com.overzealouslotus.glintstyne.datagen;

import com.google.common.collect.ImmutableSet;
import com.overzealouslotus.glintstyne.Glintstyne;
import com.overzealouslotus.glintstyne.block.GlintBlocks;
import com.overzealouslotus.glintstyne.item.GlintItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public final class GlintRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final ImmutableSet<ItemLike> MOCHITE_SOURCES = ImmutableSet.of(
      GlintItems.RAW_MOCHITE.get()
    );
    public GlintRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        oreBlasting(consumer, MOCHITE_SOURCES, RecipeCategory.MISC, GlintItems.MOCHITE.get(),
            0.25F, 100, "mochite");
        oreSmelting(consumer, MOCHITE_SOURCES, RecipeCategory.MISC, GlintItems.MOCHITE.get(),
            0.25F, 200, "mochite");

        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GlintBlocks.MOCHITE_BLOCK.get())
            .pattern("MMM")
            .pattern("MMM")
            .pattern("MMM")
            .define('M', GlintItems.MOCHITE.get())
            .unlockedBy(getHasName(GlintItems.MOCHITE.get()), has(GlintItems.MOCHITE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GlintItems.MOCHITE.get(), 9)
            .requires(GlintBlocks.MOCHITE_BLOCK.get())
            .unlockedBy(getHasName(GlintBlocks.MOCHITE_BLOCK.get()), has(GlintBlocks.MOCHITE_BLOCK.get()))
            .save(consumer);*/

        mirrorPacking(consumer, GlintItems.MOCHITE.get(), GlintBlocks.MOCHITE_BLOCK.get());
        mirrorPacking(consumer, GlintItems.RAW_MOCHITE.get(), GlintBlocks.RAW_MOCHITE_BLOCK.get());
    }

    private static void oreSmelting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, ImmutableSet<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    private static void oreBlasting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, ImmutableSet<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void mirrorPacking(@NotNull Consumer<FinishedRecipe> recipeConsumer, ItemLike unpacked, ItemLike packed) {
        nineBlockStorageRecipes(recipeConsumer, RecipeCategory.MISC, unpacked, RecipeCategory.MISC, packed);
    }

    private static void oreCooking(@NotNull Consumer<FinishedRecipe> recipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> recipeSerializer, ImmutableSet<ItemLike> ingredients, RecipeCategory category, ItemLike result, float exp, int cookingTime, String group, String recipeId) {
        for(ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(
              Ingredient.of(itemlike), category, result, exp, cookingTime, recipeSerializer)
              .group(group).unlockedBy(getHasName(itemlike), has(itemlike))
              .save(recipeConsumer, Glintstyne.MOD_ID + ":" + getItemName(result) + recipeId + "_" + getItemName(itemlike));
        }

    }
}
