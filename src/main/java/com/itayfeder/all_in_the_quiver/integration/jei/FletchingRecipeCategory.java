package com.itayfeder.all_in_the_quiver.integration.jei;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.recipes.fletching.FletchingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.Arrays;

public class FletchingRecipeCategory implements IRecipeCategory<FletchingRecipe> {
    private final IDrawable background;
    private final IDrawable icon;
    public static final ResourceLocation UID = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "fletching");
    private static final ResourceLocation FLETCHING_JEI_TEXTURE = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "textures/gui/jei_fletching.png");

    public FletchingRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(FLETCHING_JEI_TEXTURE, 0, 0, 116, 54);
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(Blocks.FLETCHING_TABLE));
    }

    public ResourceLocation getUid() {
        return UID;
    }

    public Class<? extends FletchingRecipe> getRecipeClass() {
        return FletchingRecipe.class;
    }

    /** @deprecated */
    @Deprecated
    public Component getTitle() {
        return new TranslatableComponent("gui.jei.fletching");
    }

    public MutableComponent getTitleAsTextComponent() {
        return Blocks.FLETCHING_TABLE.getName();
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    public void setIngredients(FletchingRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(Arrays.asList(recipe.fletching, recipe.shaft, recipe.arrowhead));
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    public void setRecipe(IRecipeLayout recipeLayout, FletchingRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 0, 36);
        guiItemStacks.init(1, true, 18, 18);
        guiItemStacks.init(2, true, 36, 0);
        guiItemStacks.init(3, false, 94, 18);
        guiItemStacks.set(ingredients);
    }
}