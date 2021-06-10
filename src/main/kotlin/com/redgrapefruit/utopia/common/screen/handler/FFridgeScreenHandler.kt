package com.redgrapefruit.utopia.common.screen.handler

import com.redgrapefruit.utopia.api.ContainerScreenHandler
import com.redgrapefruit.utopia.common.block.entity.FFridgeBlockEntity
import com.redgrapefruit.utopia.common.core.state.RFridgeState
import com.redgrapefruit.utopia.common.item.RFoodItem
import com.redgrapefruit.utopia.common.item.ROverdueFoodItem
import com.redgrapefruit.utopia.common.item.RRottenFoodItem
import com.redgrapefruit.utopia.common.registry.FScreenHandlerRegistry
import com.redgrapefruit.utopia.common.util.ItemMixinAccess
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerListener
import net.minecraft.screen.slot.Slot
import net.minecraft.util.collection.DefaultedList

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
        addListener(FFridgeScreenHandlerListener())
    }
}

/**
 * A [ScreenHandlerListener] linked to the [FFridgeScreenHandler] processing the slots
 */
class FFridgeScreenHandlerListener : ScreenHandlerListener {
    override fun onSlotUpdate(handler: ScreenHandler, slotId: Int, stack: ItemStack) {
        // The listener doesn't track the player's slots
        if (slotId > 9) return

        // Retrieve current and previous item at this slot and proceed if they are different
        val currentItem = stack.item
        val previousItem = handler.stacks[slotId].item
        if (currentItem == previousItem) return

        // If the previous item is a food item, set its fridge state to not compensated (inventoryTick call hasn't occurred yet)
        // If the current item is a food item, set its fridge state to inside the fridge
        // Repeat for both food implementations (RFoodItem and ItemMixin)
        // For the mixin implementation, make sure that the item is activated
        if (currentItem is RFoodItem) {
            currentItem.profile.fridgeState = RFridgeState.IN_FRIDGE
        }
        if (previousItem is RFoodItem) {
            previousItem.profile.fridgeState = RFridgeState.NOT_COMPENSATED
        }
        if (currentItem is ItemMixinAccess && currentItem.isActivated()) {
            currentItem.getProfile()!!.fridgeState = RFridgeState.IN_FRIDGE
        }
        if (previousItem is ItemMixinAccess && previousItem.isActivated()) {
            previousItem.getProfile()!!.fridgeState = RFridgeState.NOT_COMPENSATED
        }
    }

    override fun onPropertyUpdate(handler: ScreenHandler, property: Int, value: Int) = Unit
}