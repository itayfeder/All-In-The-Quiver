package com.itayfeder.all_in_the_quiver.arrows.paint;

import com.itayfeder.all_in_the_quiver.arrows.paint.data.PaintArrowDye;
import com.itayfeder.all_in_the_quiver.arrows.paint.data.PaintArrowReloadListener;
import com.itayfeder.all_in_the_quiver.arrows.pufferfish.PufferfishArrow;
import com.itayfeder.all_in_the_quiver.init.EntityTypeInit;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import com.mojang.math.Vector3f;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import java.util.Map;

public class PaintArrow extends AbstractArrow {
    private static final EntityDataAccessor<Integer> ID_COLOR = SynchedEntityData.defineId(PaintArrow.class, EntityDataSerializers.INT);

    public PaintArrow(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(EntityTypeInit.PAINT_ARROW.get(), world);
        this.setBaseDamage(1D);
    }

    public PaintArrow(EntityType<? extends PaintArrow> p_37411_, Level p_37412_) {
        super(p_37411_, p_37412_);
        setColor(DyeColor.WHITE.getId());
        this.setBaseDamage(1D);
    }

    public PaintArrow(Level p_37419_, LivingEntity p_37420_, DyeColor color) {
        super(EntityTypeInit.PAINT_ARROW.get(), p_37420_, p_37419_);
        setColor(color.getId());
        this.setBaseDamage(1D);
    }

    public PaintArrow(Level p_37414_, double p_37415_, double p_37416_, double p_37417_) {
        super(EntityTypeInit.PAINT_ARROW.get(), p_37415_, p_37416_, p_37417_, p_37414_);
        this.setBaseDamage(1D);
    }

    public void tick() {
        super.tick();
        if (this.level.isClientSide && !this.inGround) {
            this.level.addParticle(new DustParticleOptions(new Vector3f(getColor().getTextureDiffuseColors()), 1.0F), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }

    }

    @Override
    protected ItemStack getPickupItem() {
        ItemStack paintArrow = new ItemStack(ItemInit.PAINT_ARROW);
        PaintArrowItem.setColor(paintArrow, this.getColor());
        return paintArrow;
    }

    @Override
    protected void onHitEntity(EntityHitResult p_36757_) {
        super.onHitEntity(p_36757_);
        if (p_36757_.getEntity() instanceof Sheep) {
            Sheep sheep = (Sheep) p_36757_.getEntity();
            sheep.setColor(this.getColor());
        }
        if (p_36757_.getEntity() instanceof Wolf) {
            Wolf wolf = (Wolf) p_36757_.getEntity();
            wolf.setCollarColor(this.getColor());
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        super.onHitBlock(p_36755_);
        PaintArrowDye currentDye = PaintArrowReloadListener.INSTANCE.getCurrentDye(this.level.getBlockState(p_36755_.getBlockPos()).getBlock());
        if (currentDye != null) {
            this.level.setBlockAndUpdate(p_36755_.getBlockPos(), currentDye.getColorToBlock().get(this.getColor()).defaultBlockState());
            kill();
        }
    }

    public DyeColor getColor() {
        return DyeColor.byId(this.entityData.get(ID_COLOR));
    }

    private void setColor(int p_36883_) {
        this.entityData.set(ID_COLOR, p_36883_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_COLOR, DyeColor.WHITE.getId());
    }


    @Override
    public void readAdditionalSaveData(CompoundTag p_36761_) {
        super.readAdditionalSaveData(p_36761_);
        if (p_36761_.contains("Color")) {
            setColor(p_36761_.getInt("Color"));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_36772_) {
        super.addAdditionalSaveData(p_36772_);
        p_36772_.putInt("Color", this.getColor().getId());
    }
}
