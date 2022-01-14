package com.itayfeder.all_in_the_quiver;

import com.itayfeder.all_in_the_quiver.init.EntityTypeInit;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import com.itayfeder.all_in_the_quiver.init.MenuInit;
import com.itayfeder.all_in_the_quiver.init.RecipeInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AllInTheQuiverMod.MOD_ID)
public class AllInTheQuiverMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "all_in_the_quiver";

    public AllInTheQuiverMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(RecipeSerializer.class, RecipeInit::registerRecipeSerializers);
        MenuInit.CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityTypeInit.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    public static final CreativeModeTab TAB = new CreativeModeTab("quiver") {
        @Override
        public ItemStack makeIcon() {
            Random rnd = new Random();
            switch (rnd.nextInt(5)) {
                case 0:
                default:
                    return ItemInit.EXPLOSIVE_ARROW.getDefaultInstance();
                case 1:
                    return ItemInit.PUFFERFISH_ARROW.getDefaultInstance();
                case 2:
                    return ItemInit.PRISMARINE_ARROW.getDefaultInstance();
                case 3:
                    return ItemInit.SLIME_ARROW.getDefaultInstance();
                case 4:
                    return ItemInit.MESSAGE_ARROW.getDefaultInstance();
            }
        }
    };
}
