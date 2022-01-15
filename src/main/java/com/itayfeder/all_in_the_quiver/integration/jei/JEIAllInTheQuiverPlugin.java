package com.itayfeder.all_in_the_quiver.integration.jei;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrow;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrowItem;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import com.itayfeder.all_in_the_quiver.init.RecipeInit;
import com.itayfeder.all_in_the_quiver.recipes.paint_arrow.PaintArrowRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.plugins.vanilla.crafting.CraftingRecipeCategory;
import mezz.jei.plugins.vanilla.crafting.VanillaRecipes;
import mezz.jei.plugins.vanilla.crafting.replacers.ShulkerBoxColoringRecipeMaker;
import mezz.jei.plugins.vanilla.crafting.replacers.SuspiciousStewRecipeMaker;
import mezz.jei.plugins.vanilla.crafting.replacers.TippedArrowRecipeMaker;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.*;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

        registry.addRecipes(PaintArrowRecipeMaker.createRecipes().toList(), VanillaRecipeCategoryUid.CRAFTING);
    }

    private static <T extends Recipe<C>, C extends Container> Collection<T> sortRecipes(RecipeType<T> type, Comparator<? super T> comparator) {
        @SuppressWarnings("unchecked")
        Collection<T> recipes = (Collection<T>) RecipeInit.getRecipes(Minecraft.getInstance().level, type).values();
        List<T> list = new ArrayList<>(recipes);
        list.sort(comparator);
        return list;
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        registration.registerSubtypeInterpreter(ItemInit.PAINT_ARROW, PaintArrowSubtypeInterpreter.INSTANCE);
    }

    public static class PaintArrowSubtypeInterpreter implements IIngredientSubtypeInterpreter<ItemStack> {
        public static final PaintArrowSubtypeInterpreter INSTANCE = new PaintArrowSubtypeInterpreter();

        private PaintArrowSubtypeInterpreter() {
        }

        public String apply(ItemStack itemStack, UidContext uidContext) {

            DyeColor color = PaintArrowItem.getColor(itemStack);
            String colorString = color.getName();
            StringBuilder stringBuilder = new StringBuilder(colorString);
            stringBuilder.append(";").append(color);

            return stringBuilder.toString();
        }
    }
}
