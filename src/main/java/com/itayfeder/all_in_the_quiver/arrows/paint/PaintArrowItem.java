package com.itayfeder.all_in_the_quiver.arrows.paint;

import com.itayfeder.all_in_the_quiver.init.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PaintArrowItem extends ArrowItem {
    public PaintArrowItem(Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractArrow createArrow(Level p_43237_, ItemStack p_43238_, LivingEntity p_43239_) {
        return new PaintArrow(p_43237_, p_43239_, getColor(p_43238_));
    }

    @Override
    public void fillItemCategory(CreativeModeTab p_41391_, NonNullList<ItemStack> p_41392_) {
        if (this.getCreativeTabs().contains(p_41391_)) {
            for(DyeColor color : DyeColor.values()) {
                ItemStack is = new ItemStack(((PaintArrowItem) ItemInit.PAINT_ARROW), 1);
                setColor(is, color);
                p_41392_.add(is);
            }
        }
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack def = super.getDefaultInstance();
        setColor(def, DyeColor.WHITE);
        return def;
    }

    public static void setColor(ItemStack p_220011_0_, DyeColor p_220011_1_) {
        CompoundTag compoundnbt = p_220011_0_.getOrCreateTag();
        compoundnbt.putInt("Color", p_220011_1_.getId());
    }

    public static DyeColor getColor(ItemStack p_220012_0_) {
        CompoundTag compoundnbt = p_220012_0_.getOrCreateTag();
        if (compoundnbt != null) {

            return DyeColor.byId(compoundnbt.getInt("Color"));
        }
        return null;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent(ChatFormatting.GRAY + I18n.get("color.minecraft." + getColor(p_41421_).getSerializedName(), new Object[0])));
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }


}
