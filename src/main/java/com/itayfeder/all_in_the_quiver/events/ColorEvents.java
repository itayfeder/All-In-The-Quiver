package com.itayfeder.all_in_the_quiver.events;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrowItem;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AllInTheQuiverMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorEvents {
    @SubscribeEvent
    public static void registerColorHandlers(ColorHandlerEvent.Item event) {

        registerItemColorHandlers(event.getItemColors());
    }

    private static void registerItemColorHandlers(final ItemColors itemColors) {
        itemColors.register((stack, color) -> {
            return color > 0 ? -1 : ((DyeableLeatherItem)stack.getItem()).getColor(stack);
        }, ItemInit.QUIVER);

        itemColors.register((p_getColor_1_, p_getColor_2_) -> {
            return p_getColor_2_ <= 0 ? -1 : PaintArrowItem.getColor(p_getColor_1_).getFireworkColor();
        }, ItemInit.PAINT_ARROW);
    }
}
