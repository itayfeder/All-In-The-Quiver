package com.itayfeder.all_in_the_quiver.init;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.explosive.ExplosiveArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.hookshot.HookshotArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.ink.InkArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.message.MessageArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.prismarine.PrismarineArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.pufferfish.PufferfishArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.slime.SlimeArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.teleportation.TeleportationArrowItem;
import com.itayfeder.all_in_the_quiver.arrows.torch.TorchArrowItem;
import com.itayfeder.all_in_the_quiver.quiver.QuiverItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = AllInTheQuiverMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static final Item QUIVER = new QuiverItem((new Item.Properties()).stacksTo(1).tab(AllInTheQuiverMod.TAB));

    public static final Item PUFFERFISH_ARROW = new PufferfishArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item EXPLOSIVE_ARROW = new ExplosiveArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item SLIME_ARROW = new SlimeArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item PRISMARINE_ARROW = new PrismarineArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item HOOKSHOT_ARROW = new HookshotArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item MESSAGE_ARROW = new MessageArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item TELEPORTATION_ARROW = new TeleportationArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item INK_ARROW = new InkArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item TORCH_ARROW = new TorchArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));
    public static final Item PAINT_ARROW = new PaintArrowItem((new Item.Properties()).tab(AllInTheQuiverMod.TAB));

    public static void register(IForgeRegistry<Item> registry, Item item, String id) {
        item.setRegistryName(new ResourceLocation(AllInTheQuiverMod.MOD_ID, id));
        registry.register(item);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> registry) {
        register(registry.getRegistry(), QUIVER, "quiver");

        register(registry.getRegistry(), PUFFERFISH_ARROW, "pufferfish_arrow");
        register(registry.getRegistry(), EXPLOSIVE_ARROW, "explosive_arrow");
        register(registry.getRegistry(), SLIME_ARROW, "slime_arrow");
        register(registry.getRegistry(), PRISMARINE_ARROW, "prismarine_arrow");
        register(registry.getRegistry(), HOOKSHOT_ARROW, "hookshot_arrow");
        register(registry.getRegistry(), MESSAGE_ARROW, "message_arrow");
        register(registry.getRegistry(), TELEPORTATION_ARROW, "teleportation_arrow");
        register(registry.getRegistry(), INK_ARROW, "ink_arrow");
        register(registry.getRegistry(), TORCH_ARROW, "torch_arrow");
        register(registry.getRegistry(), PAINT_ARROW, "paint_arrow");
    }
}
