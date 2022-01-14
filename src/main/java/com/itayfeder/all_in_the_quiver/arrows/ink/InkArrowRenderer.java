package com.itayfeder.all_in_the_quiver.arrows.ink;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class InkArrowRenderer extends ArrowRenderer<InkArrow> {
    public static final ResourceLocation RES_INK_ARROW = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "textures/entity/projectiles/ink_arrow.png");

    public InkArrowRenderer(EntityRendererProvider.Context p_174399_) {
        super(p_174399_);
    }

    public ResourceLocation getTextureLocation(InkArrow p_116001_) {
        return RES_INK_ARROW;
    }
}