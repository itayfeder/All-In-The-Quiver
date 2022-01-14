package com.itayfeder.all_in_the_quiver.arrows.prismarine;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PrismarineArrowRenderer extends ArrowRenderer<PrismarineArrow> {
    public static final ResourceLocation RES_PRISMARINE_ARROW = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "textures/entity/projectiles/prismarine_arrow.png");

    public PrismarineArrowRenderer(EntityRendererProvider.Context p_174399_) {
        super(p_174399_);
    }

    public ResourceLocation getTextureLocation(PrismarineArrow p_116001_) {
        return RES_PRISMARINE_ARROW;
    }
}