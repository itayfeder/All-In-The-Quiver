package com.itayfeder.all_in_the_quiver.recipes.fletching;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import net.minecraft.world.item.crafting.RecipeType;

public class FletchingRecipeType implements RecipeType<FletchingRecipe> {

    @Override
    public String toString () {
        return AllInTheQuiverMod.MOD_ID + ":fletching";
    }
}