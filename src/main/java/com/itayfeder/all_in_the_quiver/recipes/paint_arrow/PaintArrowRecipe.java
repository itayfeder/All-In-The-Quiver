package com.itayfeder.all_in_the_quiver.recipes.paint_arrow;

import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrow;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrowItem;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.item.crafting.TippedArrowRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ForgeItemTagsProvider;

public class PaintArrowRecipe extends CustomRecipe {
    public PaintArrowRecipe(ResourceLocation p_44503_) {
        super(p_44503_);
    }

    public boolean matches(CraftingContainer p_44515_, Level p_44516_) {
        if (p_44515_.getWidth() == 3 && p_44515_.getHeight() == 3) {
            for(int i = 0; i < p_44515_.getWidth(); ++i) {
                for(int j = 0; j < p_44515_.getHeight(); ++j) {
                    ItemStack itemstack = p_44515_.getItem(i + j * p_44515_.getWidth());
                    if (itemstack.isEmpty()) {
                        return false;
                    }

                    if (i == 1 && j == 1) {
                        if (!(itemstack.getItem() instanceof DyeItem)) {
                            return false;
                        }
                    } else if (!itemstack.is(ItemInit.PAINT_ARROW)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public ItemStack assemble(CraftingContainer p_44513_) {
        ItemStack itemstack = p_44513_.getItem(1 + p_44513_.getWidth());
        if (!(itemstack.getItem() instanceof DyeItem)) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemstack1 = new ItemStack(ItemInit.PAINT_ARROW, 8);
            PaintArrowItem.setColor(itemstack1, ((DyeItem)itemstack.getItem()).getDyeColor());
            return itemstack1;
        }
    }

    public boolean canCraftInDimensions(int p_44505_, int p_44506_) {
        return p_44505_ >= 2 && p_44506_ >= 2;
    }

    public static SimpleRecipeSerializer<PaintArrowRecipe> PAINT_ARROW = new SimpleRecipeSerializer<>(PaintArrowRecipe::new);

    public RecipeSerializer<?> getSerializer() {
        return PAINT_ARROW;
    }
}