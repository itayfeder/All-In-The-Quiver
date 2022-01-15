package com.itayfeder.all_in_the_quiver.arrows.golden;

import com.itayfeder.all_in_the_quiver.arrows.ink.InkArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GoldenArrowItem extends ArrowItem {
    public GoldenArrowItem(Item.Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractArrow createArrow(Level p_43237_, ItemStack p_43238_, LivingEntity p_43239_) {
        return new GoldenArrow(p_43237_, p_43239_);
    }
}
