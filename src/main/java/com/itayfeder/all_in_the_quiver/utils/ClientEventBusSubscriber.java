package com.itayfeder.all_in_the_quiver.utils;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.explosive.ExplosiveArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.hookshot.HookshotArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.ink.InkArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.message.MessageArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.prismarine.PrismarineArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.pufferfish.PufferfishArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.slime.SlimeArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.teleportation.TeleportationArrowRenderer;
import com.itayfeder.all_in_the_quiver.arrows.torch.TorchArrowRenderer;
import com.itayfeder.all_in_the_quiver.fletching_table.FletchingTableScreen;
import com.itayfeder.all_in_the_quiver.init.EntityTypeInit;
import com.itayfeder.all_in_the_quiver.init.MenuInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AllInTheQuiverMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityTypeInit.PUFFERFISH_ARROW.get(), PufferfishArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.EXPLOSIVE_ARROW.get(), ExplosiveArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.SLIME_ARROW.get(), SlimeArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.PRISMARINE_ARROW.get(), PrismarineArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.HOOKSHOT_ARROW.get(), HookshotArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.MESSAGE_ARROW.get(), MessageArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.TELEPORTATION_ARROW.get(), TeleportationArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.INK_ARROW.get(), InkArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.TORCH_ARROW.get(), TorchArrowRenderer::new);
        EntityRenderers.register(EntityTypeInit.PAINT_ARROW.get(), PaintArrowRenderer::new);

        MenuScreens.register(MenuInit.FLETCHING_TABLE.get(), FletchingTableScreen::new);
    }
}
