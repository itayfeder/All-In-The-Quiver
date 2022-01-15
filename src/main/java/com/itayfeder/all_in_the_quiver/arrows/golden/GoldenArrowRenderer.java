package com.itayfeder.all_in_the_quiver.arrows.golden;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.message.MessageArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GoldenArrowRenderer extends ArrowRenderer<GoldenArrow> {
    public static final ResourceLocation RES_GOLDEN_ARROW = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "textures/entity/projectiles/golden_arrow.png");

    public GoldenArrowRenderer(EntityRendererProvider.Context p_174399_) {
        super(p_174399_);
    }

    public ResourceLocation getTextureLocation(GoldenArrow p_116001_) {
        return RES_GOLDEN_ARROW;
    }
}