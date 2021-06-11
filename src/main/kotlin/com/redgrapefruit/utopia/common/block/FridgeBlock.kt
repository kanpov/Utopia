package com.redgrapefruit.utopia.common.block

import com.redgrapefruit.utopia.api.ContainerBlock
import com.redgrapefruit.utopia.common.block.entity.FridgeBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.inventory.Inventory
import net.minecraft.util.math.BlockPos

/**
 * A fridge block implementing Container API
 */
class FridgeBlock(settings: Settings) : ContainerBlock(settings) {
    override fun checkBlockEntity(blockEntity: BlockEntity): Boolean {
        return blockEntity is FridgeBlockEntity
    }

    override fun castToInventory(blockEntity: BlockEntity): Inventory {
        return blockEntity as FridgeBlockEntity
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return FridgeBlockEntity(pos, state)
    }
}