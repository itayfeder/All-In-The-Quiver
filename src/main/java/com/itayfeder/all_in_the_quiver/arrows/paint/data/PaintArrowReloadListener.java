package com.itayfeder.all_in_the_quiver.arrows.paint.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.util.perf.Profiler;

import java.util.Map;
import java.util.Set;

public class PaintArrowReloadListener extends SimpleJsonResourceReloadListener {
    public static final PaintArrowReloadListener INSTANCE;
    public static final Gson GSON = new GsonBuilder().create();
    public final BiMap<ResourceLocation, PaintArrowDye> paintArrowDyes;

    public PaintArrowReloadListener() {
        super(GSON, "paint_arrow_dye");
        this.paintArrowDyes = HashBiMap.create();
    }

    static {
        INSTANCE = new PaintArrowReloadListener();
    }

    public Set<PaintArrowDye> getPaintArrowDyes() {
        return paintArrowDyes.values();
    }

    public PaintArrowDye getCurrentDye(Block block) {
        for (PaintArrowDye recipe : this.getPaintArrowDyes()) {
            if (recipe.CanUseRecipe(block)) {
                return recipe;
            }
        }
        return null;
    }

    protected void apply(Map<ResourceLocation, JsonElement> objectIn, ResourceManager resourceManagerIn, ProfilerFiller profilerIn) {
        for (Map.Entry<ResourceLocation, JsonElement> entry : objectIn.entrySet()) {
            ResourceLocation name = entry.getKey();
            String[] split = name.getPath().split("/");
            if (split[split.length - 1].startsWith("_"))
                continue;
            JsonObject json = entry.getValue().getAsJsonObject();
            try {
                PaintArrowDye recipe = PaintArrowDye.deserialize(json);
                paintArrowDyes.put(name, recipe);
            } catch (IllegalArgumentException | JsonParseException e) {
                System.out.println(String.format("I got an error!!!: ", e));
            }
        }

        System.out.println(String.format("%s Paint Arrow Dyes loaded successfully !", paintArrowDyes.size()));
    }
}
