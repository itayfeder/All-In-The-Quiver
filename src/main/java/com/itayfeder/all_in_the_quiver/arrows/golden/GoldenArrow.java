package com.itayfeder.all_in_the_quiver.arrows.golden;

import com.itayfeder.all_in_the_quiver.arrows.freezing.FreezingArrow;
import com.itayfeder.all_in_the_quiver.arrows.paint.PaintArrow;
import com.itayfeder.all_in_the_quiver.init.EntityTypeInit;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import com.mojang.math.Vector3f;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

public class GoldenArrow extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> WAS_EFFECTED = SynchedEntityData.defineId(GoldenArrow.class, EntityDataSerializers.BOOLEAN);

    public GoldenArrow(EntityType<? extends GoldenArrow> p_37411_, Level p_37412_) {
        super(p_37411_, p_37412_);
        this.setBaseDamage(1D);
    }

    public GoldenArrow(Level p_37419_, LivingEntity p_37420_) {
        super(EntityTypeInit.GOLDEN_ARROW.get(), p_37420_, p_37419_);
        this.setBaseDamage(1D);
    }

    public GoldenArrow(Level p_37414_, double p_37415_, double p_37416_, double p_37417_) {
        super(EntityTypeInit.GOLDEN_ARROW.get(), p_37415_, p_37416_, p_37417_, p_37414_);
        this.setBaseDamage(1D);
    }

    public GoldenArrow(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(EntityTypeInit.GOLDEN_ARROW.get(), world);
        this.setBaseDamage(1D);
    }

    public void tick() {
        super.tick();
        if (!getWasEffected()) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.25D, 1.25D, 1.25D));
            this.setWasEffected(true);
        }

    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.GOLDEN_ARROW);
    }

    public Boolean getWasEffected() {
        return this.entityData.get(WAS_EFFECTED);
    }

    private void setWasEffected(Boolean p_36883_) {
        this.entityData.set(WAS_EFFECTED, p_36883_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WAS_EFFECTED, false);
    }


    @Override
    public void readAdditionalSaveData(CompoundTag p_36761_) {
        super.readAdditionalSaveData(p_36761_);
        if (p_36761_.contains("WasEffected")) {
            setWasEffected(p_36761_.getBoolean("WasEffected"));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_36772_) {
        super.addAdditionalSaveData(p_36772_);
        p_36772_.putBoolean("WasEffected", this.getWasEffected());

    }
}