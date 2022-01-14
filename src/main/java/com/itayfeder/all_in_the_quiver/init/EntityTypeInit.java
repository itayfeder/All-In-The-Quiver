package com.itayfeder.all_in_the_quiver.init;

import com.itayfeder.all_in_the_quiver.AllInTheQuiverMod;
import com.itayfeder.all_in_the_quiver.arrows.explosive.ExplosiveArrow;
import com.itayfeder.all_in_the_quiver.arrows.hookshot.HookshotArrow;
import com.itayfeder.all_in_the_quiver.arrows.ink.InkArrow;
import com.itayfeder.all_in_the_quiver.arrows.message.MessageArrow;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrow;
import com.itayfeder.all_in_the_quiver.arrows.prismarine.PrismarineArrow;
import com.itayfeder.all_in_the_quiver.arrows.pufferfish.PufferfishArrow;
import com.itayfeder.all_in_the_quiver.arrows.slime.SlimeArrow;
import com.itayfeder.all_in_the_quiver.arrows.teleportation.TeleportationArrow;
import com.itayfeder.all_in_the_quiver.arrows.torch.TorchArrow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypeInit {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, AllInTheQuiverMod.MOD_ID);

    public static final RegistryObject<EntityType<PufferfishArrow>> PUFFERFISH_ARROW = ENTITY_TYPES.register("pufferfish_arrow",
            () -> EntityType.Builder.<PufferfishArrow>of(PufferfishArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(PufferfishArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "pufferfish_arrow").toString()));

    public static final RegistryObject<EntityType<ExplosiveArrow>> EXPLOSIVE_ARROW = ENTITY_TYPES.register("explosive_arrow",
            () -> EntityType.Builder.<ExplosiveArrow>of(ExplosiveArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(ExplosiveArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "explosive_arrow").toString()));

    public static final RegistryObject<EntityType<SlimeArrow>> SLIME_ARROW = ENTITY_TYPES.register("slime_arrow",
            () -> EntityType.Builder.<SlimeArrow>of(SlimeArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(SlimeArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "slime_arrow").toString()));

    public static final RegistryObject<EntityType<PrismarineArrow>> PRISMARINE_ARROW = ENTITY_TYPES.register("prismarine_arrow",
            () -> EntityType.Builder.<PrismarineArrow>of(PrismarineArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(PrismarineArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "prismarine_arrow").toString()));

    public static final RegistryObject<EntityType<HookshotArrow>> HOOKSHOT_ARROW = ENTITY_TYPES.register("hookshot_arrow",
            () -> EntityType.Builder.<HookshotArrow>of(HookshotArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(HookshotArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "hookshot_arrow").toString()));

    public static final RegistryObject<EntityType<MessageArrow>> MESSAGE_ARROW = ENTITY_TYPES.register("message_arrow",
            () -> EntityType.Builder.<MessageArrow>of(MessageArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(MessageArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "message_arrow").toString()));

    public static final RegistryObject<EntityType<TeleportationArrow>> TELEPORTATION_ARROW = ENTITY_TYPES.register("teleportation_arrow",
            () -> EntityType.Builder.<TeleportationArrow>of(TeleportationArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(TeleportationArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "teleportation_arrow").toString()));

    public static final RegistryObject<EntityType<InkArrow>> INK_ARROW = ENTITY_TYPES.register("ink_arrow",
            () -> EntityType.Builder.<InkArrow>of(InkArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(InkArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "ink_arrow").toString()));

    public static final RegistryObject<EntityType<TorchArrow>> TORCH_ARROW = ENTITY_TYPES.register("torch_arrow",
            () -> EntityType.Builder.<TorchArrow>of(TorchArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(TorchArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "torch_arrow").toString()));

    public static final RegistryObject<EntityType<PaintArrow>> PAINT_ARROW = ENTITY_TYPES.register("paint_arrow",
            () -> EntityType.Builder.<PaintArrow>of(PaintArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(PaintArrow::new)
                    .build(new ResourceLocation(AllInTheQuiverMod.MOD_ID, "paint_arrow").toString()));
}
