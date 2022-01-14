package com.itayfeder.all_in_the_quiver.events;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.paint.data.PaintArrowReloadListener;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AllInTheQuiverMod.MOD_ID)
public class ServerLoadingEvent {

    @SubscribeEvent
    public static void onServerAboutToStart(AddReloadListenerEvent event) {
        event.addListener(PaintArrowReloadListener.INSTANCE);

    }
}
