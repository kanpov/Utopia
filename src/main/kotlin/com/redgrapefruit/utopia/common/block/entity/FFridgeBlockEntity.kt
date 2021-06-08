package com.redgrapefruit.utopia.common.block.entity

import com.redgrapefruit.utopia.api.ContainerBlockEntity
import com.redgrapefruit.utopia.common.registry.FBlockRegistry
import com.redgrapefruit.utopia.common.screen.handler.FFridgeScreenHandler
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.util.collection.DefaultedList

/**
 * A fridge [BlockEntity] implementing the Container API
 */
class FFridgeBlockEntity : ContainerBlockEntity(FBlockRegistry.FRIDGE_BLOCK_ENTITY) {
    override val containerSize: Int = 9
    override val items: DefaultedList<ItemStack> = inventory

    override fun createMenu(syncId: Int, playerInventory: PlayerInventory, player: PlayerEntity): ScreenHandler {
        return FFridgeScreenHandler(syncId, playerInventory, this)
    }
}