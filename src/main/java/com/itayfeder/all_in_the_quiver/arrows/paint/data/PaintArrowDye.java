package com.itayfeder.all_in_the_quiver.arrows.paint.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.mojang.realmsclient.util.JsonUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.SerializationTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class PaintArrowDye {
    public ResourceLocation replacingTag;
    public Map<String, ResourceLocation> colorToBlock;

    public PaintArrowDye(ResourceLocation replacingTag, Map<String, ResourceLocation> colorToBlock) {
        this.replacingTag = replacingTag;
        this.colorToBlock = colorToBlock;
    }

    @Override
    public String toString() {
        return String.format("TermiteEatingRecipe[replacingTag: %s, colorToBlock: %s]", this.replacingTag.toString(), this.colorToBlock.toString());
    }

    public boolean CanUseRecipe(Block block) {
        ResourceLocation blockLocation = block.getRegistryName();
        Tag<Block> tag = SerializationTags.getInstance().getTagOrThrow(Registry.BLOCK_REGISTRY, this.replacingTag, (p_151262_) -> {
            return new JsonSyntaxException("Unknown item tag '" + p_151262_ + "'");
        });
        return tag.contains(block);
    }

    public static PaintArrowDye deserialize(JsonObject json) {
        if (!json.isJsonObject())
            throw new JsonParseException("PaintArrowDye must be a JSON Object");

        JsonObject jsonObject = json.getAsJsonObject();
        String ingrid = JsonUtils.getStringOr("recplaceTag", jsonObject, "test");
        ResourceLocation ingridId = ResourceLocation.tryParse(ingrid);
        if (ingridId == null)
            throw new JsonParseException("recplaceTag is not valid");

        JsonElement coloredElement = json.get("colored");
        if (coloredElement == null)
            throw new JsonParseException("colored is not valid");
        Map<String, ResourceLocation> colorMap = new HashMap<>();
        for(DyeColor color : DyeColor.values()) {
            String location = JsonUtils.getStringOr(color.getName(), coloredElement.getAsJsonObject(), null);
            ResourceLocation locationid = ResourceLocation.tryParse(location);
            if (locationid == null)
                throw new JsonParseException("colored." + color.getName() + " is not valid");
            colorMap.put(color.getName(), locationid);
        }

        return new PaintArrowDye(ingridId, colorMap);

    }

    public Tag<Block> getReplacingTag() {
        Tag<Block> tag = SerializationTags.getInstance().getTagOrThrow(Registry.BLOCK_REGISTRY, this.replacingTag, (p_151262_) -> {
            return new JsonSyntaxException("Unknown item tag '" + p_151262_ + "'");
        });
        return tag;
    }

    public Map<DyeColor, Block> getColorToBlock() {
        Map<DyeColor, Block> actualColorToBlock = new HashMap<>();
        for (Map.Entry<String, ResourceLocation> entry : this.colorToBlock.entrySet()) {
            actualColorToBlock.put(DyeColor.byName(entry.getKey(), DyeColor.WHITE), ForgeRegistries.BLOCKS.getValue(entry.getValue()));
        }
        return actualColorToBlock;
    }
}
