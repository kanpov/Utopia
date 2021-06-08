package com.redgrapefruit.utopia.common.screen.handler

import com.redgrapefruit.utopia.api.ContainerScreenHandler
import com.redgrapefruit.utopia.common.block.entity.FFridgeBlockEntity
import com.redgrapefruit.utopia.common.registry.FScreenHandlerRegistry
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.screen.ScreenHandler

/**
 * A fridge [ScreenHandler] implementing the Container API.
 *
 * The primary constructor is the server constructor called by the [FFridgeBlockEntity]
 *
 * The secondary constructor is the client constructor which creates a 9-slot [SimpleInventory] and passes it onto the server constructor
 */
class FFridgeScreenHandler
    (syncId: Int, playerInventory: PlayerInventory, inventory: Inventory)
    : ContainerScreenHandler(syncId, playerInventory, inventory, 9, FScreenHandlerRegistry.FRIDGE_SCREEN_HANDLER) {

    constructor(syncId: Int, playerInventory: PlayerInventory) : this(syncId, playerInventory, SimpleInventory(9))

    override fun onSlotInit(inventory: Inventory, playerInventory: PlayerInventory) {
        // Custom 3x3 inventory
        var index = 0
        for (y in 0..2) {
            for (x in 0..2) {
                addGridSlot(inventory, index, x, y)
                index++
            }
        }
        // Player inventory and hotbar
        addPlayerInventorySlots(playerInventory)
        addPlayerHotbarSlots(playerInventory)
    }

    override fun onListenerInit() {
    }
}