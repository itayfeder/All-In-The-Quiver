package com.itayfeder.all_in_the_quiver.quiver;

import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public class QuiverItemStackHandler extends ItemStackHandler {
    public static final int NUMBER_SLOTS = 5;

    public QuiverItemStackHandler() {
        super(5);
    }

    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        if (slot >= 0 && slot < 5) {
            if (stack.isEmpty()) {
                return false;
            } else {
                return (stack.getItem() instanceof ArrowItem);
            }
        } else {
            throw new IllegalArgumentException("Invalid slot number: " + slot);
        }
    }

    public boolean isEmpty() {
        return this.stacks.isEmpty();
    }

    public List<ItemStack> getItems() {
        return this.stacks.stream().toList();
    }

    public ItemStack addStack(ItemStack stack) {
        ItemStack addedStack = stack.copy();
        for (int i = 0; i < this.stacks.size(); i++) {
            addedStack = this.insertItem(i, addedStack, false);
            if (addedStack == ItemStack.EMPTY) i = this.stacks.size();
        }

        return addedStack;

    }
}
