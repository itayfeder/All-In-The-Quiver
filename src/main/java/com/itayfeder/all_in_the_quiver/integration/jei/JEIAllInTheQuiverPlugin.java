package com.itayfeder.all_in_the_quiver.integration.jei;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.init.RecipeInit;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@JeiPlugin
public class JEIAllInTheQuiverPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "jei_plugin");

    @Override
    @Nonnull
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(
                new FletchingRecipeCategory(registry.getJeiHelpers().getGuiHelper())
        );
    }

    private static final Comparator<Recipe<?>> BY_ID = Comparator.comparing(Recipe::getId);
    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registry) {
        registry.addRecipes(sortRecipes(RecipeInit.FLETCHING_RECIPE, BY_ID), FletchingRecipeCategory.UID);
    }

    private static <T extends Recipe<C>, C extends Container> Collection<T> sortRecipes(RecipeType<T> type, Comparator<? super T> comparator) {
        @SuppressWarnings("unchecked")
        Collection<T> recipes = (Collection<T>) RecipeInit.getRecipes(Minecraft.getInstance().level, type).values();
        List<T> list = new ArrayList<>(recipes);
        list.sort(comparator);
        return list;
    }
}
