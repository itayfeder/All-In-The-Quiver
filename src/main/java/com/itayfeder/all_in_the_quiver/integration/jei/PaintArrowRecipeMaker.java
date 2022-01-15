package com.itayfeder.all_in_the_quiver.integration.jei;

import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrowItem;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.common.crafting.NBTIngredient;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.stream.Stream;

public class PaintArrowRecipeMaker {
    public static Stream<CraftingRecipe> createRecipes() {
        String group = "jei.paint.arrow";
        return Arrays.stream(DyeColor.values()).map((potion) -> {
            ItemStack arrowStack = new ItemStack(ItemInit.PAINT_ARROW);
            ItemStack dyeItem = new ItemStack(DyeItem.byColor(potion));
            Ingredient arrowIngredient = Ingredient.of(new ItemStack[]{arrowStack});
            Ingredient dyeIngredient = new NBTIngredient(dyeItem) {
            };
            NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, new Ingredient[]{arrowIngredient, arrowIngredient, arrowIngredient, arrowIngredient, dyeIngredient, arrowIngredient, arrowIngredient, arrowIngredient, arrowIngredient});
            ItemStack output = new ItemStack(ItemInit.PAINT_ARROW, 8);
            PaintArrowItem.setColor(output, potion);
            ResourceLocation id = new ResourceLocation("minecraft", "jei.paint.arrow." + output.getDescriptionId());
            return new ShapedRecipe(id, group, 3, 3, inputs, output);
        });
    }

    private PaintArrowRecipeMaker() {
    }
}
