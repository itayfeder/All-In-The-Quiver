package com.itayfeder.all_in_the_quiver.arrows.freezing;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.message.MessageArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class FreezingArrowRenderer extends ArrowRenderer<FreezingArrow> {
    public static final ResourceLocation RES_FREEZING_ARROW = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "textures/entity/projectiles/freezing_arrow.png");

    public FreezingArrowRenderer(EntityRendererProvider.Context p_174399_) {
        super(p_174399_);
    }

    public ResourceLocation getTextureLocation(FreezingArrow p_116001_) {
        return RES_FREEZING_ARROW;
    }
}