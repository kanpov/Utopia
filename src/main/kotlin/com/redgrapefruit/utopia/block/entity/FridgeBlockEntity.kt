package com.redgrapefruit.utopia.block.entity

import com.redgrapefruit.redmenu.redmenu.MenuBlockEntity
import com.redgrapefruit.utopia.registry.BlockRegistry
import com.redgrapefruit.utopia.screen.handler.FridgeScreenHandler
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

/**
 * A fridge [BlockEntity] implementing the Container API
 */
class FridgeBlockEntity(pos: BlockPos, state: BlockState) :
    MenuBlockEntity(BlockRegistry.FRIDGE_BLOCK_ENTITY, pos, state, 9) {

    override val items: DefaultedList<ItemStack> = inventory

    override fun createMenu(syncId: Int, playerInventory: PlayerInventory, player: PlayerEntity): ScreenHandler {
        return FridgeScreenHandler(syncId, playerInventory, this)
    }
}