package com.jamieswhiteshirt.reachentityattributes.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Inventory.class)
interface InventoryValidationMixin {
    @ModifyConstant(
        method = "canPlayerUse(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/player/PlayerEntity;)Z",
        require = 1, allow = 1, constant = @Constant(intValue = 8))
    private static int getActualReachDistance(final int reachDistance, final BlockEntity blockEntity, final PlayerEntity player) {
        return (int)ReachEntityAttributes.getReachDistance(player, reachDistance);
    }
}
