package com.itayfeder.all_in_the_quiver.arrows.freezing;

import com.itayfeder.all_in_the_quiver.arrows.pufferfish.PufferfishArrow;
import com.itayfeder.all_in_the_quiver.init.EntityTypeInit;
import com.itayfeder.all_in_the_quiver.init.ItemInit;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class FreezingArrow extends AbstractArrow {
    public FreezingArrow(EntityType<? extends FreezingArrow> p_37411_, Level p_37412_) {
        super(p_37411_, p_37412_);
    }

    public FreezingArrow(Level p_37419_, LivingEntity p_37420_) {
        super(EntityTypeInit.FREEZING_ARROW.get(), p_37420_, p_37419_);
    }

    public FreezingArrow(Level p_37414_, double p_37415_, double p_37416_, double p_37417_) {
        super(EntityTypeInit.FREEZING_ARROW.get(), p_37415_, p_37416_, p_37417_, p_37414_);
    }

    public FreezingArrow(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(EntityTypeInit.FREEZING_ARROW.get(), world);
    }

    public void tick() {
        super.tick();
        if (this.level.isClientSide && !this.inGround) {
            this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.ICE.defaultBlockState()).setPos(this.getOnPos()), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }

        if (this.level.getBlockState(this.getOnPos()).getBlock() == Blocks.WATER) {
            this.level.setBlockAndUpdate(this.getOnPos(), Blocks.ICE.defaultBlockState());
            kill();
        }

    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.FREEZING_ARROW);
    }

    @Override
    protected void onHitEntity(EntityHitResult p_36757_) {
        super.onHitEntity(p_36757_);
        p_36757_.getEntity().setTicksFrozen(p_36757_.getEntity().getTicksFrozen() + 140);
    }

    @Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        super.onHitBlock(p_36755_);
        if (this.level.getBlockState(p_36755_.getBlockPos()).getBlock() == Blocks.ICE) {
            this.level.setBlockAndUpdate(p_36755_.getBlockPos(), Blocks.PACKED_ICE.defaultBlockState());
            kill();
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_36761_) {
        super.readAdditionalSaveData(p_36761_);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_36772_) {
        super.addAdditionalSaveData(p_36772_);
    }
}