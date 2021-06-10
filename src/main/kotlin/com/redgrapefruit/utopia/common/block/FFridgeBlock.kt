package com.redgrapefruit.utopia.common.block

import com.redgrapefruit.utopia.api.ContainerBlock
import com.redgrapefruit.utopia.common.block.entity.FFridgeBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.inventory.Inventory
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

/**
 * A fridge block implementing Container API
 */
class FFridgeBlock(settings: Settings) : ContainerBlock(settings) {
    override fun checkBlockEntity(blockEntity: BlockEntity): Boolean {
        return blockEntity is FFridgeBlockEntity
    }

    override fun castToInventory(blockEntity: BlockEntity): Inventory {
        return blockEntity as FFridgeBlockEntity
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return FFridgeBlockEntity(pos, state)
    }
}