package com.overzealouslotus.glintstyne.datagen;

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

import java.util.List;
import java.util.function.Consumer;

public class GlintRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> MOCHITE_SMELTABLES = List.of(GlintItems.RAW_MOCHITE.get());
    public GlintRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        oreBlasting(consumer, MOCHITE_SMELTABLES, RecipeCategory.MISC, GlintItems.MOCHITE.get(),
            0.25F, 100, "mochite");
        oreSmelting(consumer, MOCHITE_SMELTABLES, RecipeCategory.MISC, GlintItems.MOCHITE.get(),
            0.25F, 200, "mochite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GlintBlocks.MOCHITE_BLOCK.get())
            .pattern("MMM")
            .pattern("MMM")
            .pattern("MMM")
            .define('M', GlintItems.MOCHITE.get())
            .unlockedBy(getHasName(GlintItems.MOCHITE.get()), has(GlintItems.MOCHITE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GlintItems.MOCHITE.get(), 9)
            .requires(GlintBlocks.MOCHITE_BLOCK.get())
            .unlockedBy(getHasName(GlintBlocks.MOCHITE_BLOCK.get()), has(GlintBlocks.MOCHITE_BLOCK.get()))
            .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                pExperience, pCookingTime, pCookingSerializer)
                .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                .save(pFinishedRecipeConsumer, Glintstyne.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
