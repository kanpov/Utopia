package com.redgrapefruit.utopia.screen.handler

import com.redgrapefruit.redmenu.redmenu.MenuScreenHandler
import com.redgrapefruit.utopia.block.entity.FridgeBlockEntity
import com.redgrapefruit.utopia.core.FridgeState
import com.redgrapefruit.utopia.item.AdvancedFoodItem
import com.redgrapefruit.utopia.registry.ScreenHandlerRegistry
import com.redgrapefruit.utopia.util.ItemFoodMixinAccess
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerListener

/**
 * A fridge [ScreenHandler] implementing the Container API.
 *
 * The primary constructor is the server constructor called by the [FridgeBlockEntity]
 *
 * The secondary constructor is the client constructor which creates a 9-slot [SimpleInventory] and passes it onto the server constructor
 */
class FridgeScreenHandler
    (syncId: Int, playerInventory: PlayerInventory, inventory: Inventory) :
    MenuScreenHandler(syncId, playerInventory, inventory, 9, ScreenHandlerRegistry.FRIDGE_SCREEN_HANDLER) {

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
        addListener(FridgeScreenHandlerListener())
    }
}

/**
 * A [ScreenHandlerListener] linked to the [FridgeScreenHandler] processing the slots
 */
class FridgeScreenHandlerListener : ScreenHandlerListener {
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
        if (currentItem is AdvancedFoodItem) {
            currentItem.profile.fridgeState = FridgeState.IN_FRIDGE
        }
        if (previousItem is AdvancedFoodItem) {
            previousItem.profile.fridgeState = FridgeState.NOT_COMPENSATED
        }
        if (currentItem is ItemFoodMixinAccess && currentItem.isFoodActivated()) {
            currentItem.getProfile().fridgeState = FridgeState.IN_FRIDGE
        }
        if (previousItem is ItemFoodMixinAccess && previousItem.isFoodActivated()) {
            previousItem.getProfile().fridgeState = FridgeState.NOT_COMPENSATED
        }
    }

    override fun onPropertyUpdate(handler: ScreenHandler, property: Int, value: Int) = Unit
}