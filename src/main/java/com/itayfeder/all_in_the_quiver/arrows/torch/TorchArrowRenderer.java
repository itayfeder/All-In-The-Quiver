package com.itayfeder.all_in_the_quiver.arrows.torch;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class TorchArrowRenderer extends ArrowRenderer<TorchArrow> {
    public static final ResourceLocation RES_TORCH_ARROW = new ResourceLocation(AllInTheQuiverMod.MOD_ID, "textures/entity/projectiles/torch_arrow.png");

    public TorchArrowRenderer(EntityRendererProvider.Context p_174399_) {
        super(p_174399_);
    }

    public ResourceLocation getTextureLocation(TorchArrow p_116001_) {
        return RES_TORCH_ARROW;
    }
}