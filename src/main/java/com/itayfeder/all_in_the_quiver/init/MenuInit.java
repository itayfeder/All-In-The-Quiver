package com.itayfeder.all_in_the_quiver.init;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.fletching_table.FletchingTableMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AllInTheQuiverMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MenuInit {

    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, AllInTheQuiverMod.MOD_ID);

    public static final RegistryObject<MenuType<FletchingTableMenu>> FLETCHING_TABLE = CONTAINER_TYPES
            .register("fletching_table", () -> IForgeMenuType.create(FletchingTableMenu::new));
}