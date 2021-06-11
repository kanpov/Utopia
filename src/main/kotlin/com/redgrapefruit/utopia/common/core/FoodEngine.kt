package com.redgrapefruit.utopia.common.core

import com.redgrapefruit.utopia.common.core.data.FoodConfig
import com.redgrapefruit.utopia.common.core.state.MIN_TICK_LOSS
import com.redgrapefruit.utopia.common.core.state.FoodProfile
import com.redgrapefruit.utopia.common.core.state.FoodState
import com.redgrapefruit.utopia.common.item.OverdueFoodItem
import com.redgrapefruit.utopia.common.item.RottenFoodItem
import com.redgrapefruit.utopia.common.util.*
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.world.World

object FoodEngine {
    /**
     * Main block of logic that executes every tick the item is inside of a player's inventory
     *
     * @param config Linked [FoodConfig]
     * @param profile Linked [FoodProfile]
     * @param player Owner [PlayerEntity]
     * @param slot Inventory slot
     * @param world Current [World] instance
     * @param rottenVariant Rotten variant of the given item
     * @param overdueVariant Overdue variant of the given item
     */
    fun inventoryTick(
        config: FoodConfig,
        profile: FoodProfile,
        player: PlayerEntity,
        slot: Int,
        world: World,
        rottenVariant: RottenFoodItem?,
        overdueVariant: OverdueFoodItem?,
        isSalt: Boolean) {

        // 1. Initialization of world time
        if (!profile.isInitialized) {
            profile.previousTick = world.time
            profile.isInitialized = true
        }

        // 2. Compensation of lost ticks for glitches and putting the item into a fridge/locker etc.
        // Calculate the difference between current world time and last saved world time
        val currentTick = world.time
        val difference = currentTick - profile.previousTick
        // If the difference exceeds minimal tick loss, compensate the lost ticks
        if (difference >= MIN_TICK_LOSS) {
            if (config.category.canRot) {
                profile.rotProgress += (difference * calculateRot(profile, config)).toInt()
            }
            if (config.category.canOverdue) {
                profile.overdueProgress += (difference * calculateOverdue(profile, config)).toInt()
            }
        }
        // Now save the world time for further use
        profile.previousTick = currentTick

        // 3. Updating rot and overdue
        if (config.category.canRot) {
            profile.rotProgress += calculateRot(profile, config)
        }
        if (config.category.canOverdue) {
            profile.overdueProgress += calculateOverdue(profile, config)
        }

        // 4. Salt logic
        if (isSalt) profile.rotProgress -= config.saltEfficiency

        // 5. Bound-check rot and overdue to see if the limit has been exceeded
        if (config.category.canRot && profile.rotProgress >= config.rotState) {
            // Swap the item with its rotten variant and reset counter for the stack
            player.inventory.getStack(slot).decrement(1)
            player.inventory.offerOrDrop(ItemStack(rottenVariant))
            profile.rotProgress = 0
        }
        if (config.category.canOverdue && profile.overdueProgress >= config.overdueState) {
            // Swap the item with its overdue variant and reset counter for the stack
            player.inventory.getStack(slot).decrement(1)
            player.inventory.offerOrDrop(ItemStack(overdueVariant))
            profile.overdueProgress = 0
        }
    }

    /**
     * Tooltip rendering logic which is called every tick to display the detailed stats to the player
     *
     * @param tooltip Tooltip list
     * @param config Linked [FoodConfig]
     * @param profile Linked [FoodProfile]
     * @param state Rendering [FoodState]
     */
    fun appendTooltip(tooltip: MutableList<Text>, config: FoodConfig, profile: FoodProfile, state: FoodState) {
        // State
        breakLine(tooltip)
        tooltip += LiteralText(AQUA + "State: " + state.displayName)
        // Category and its description
        breakLine(tooltip)
        tooltip += LiteralText(DARK_RED + "Category: ")
        tooltip += LiteralText(RED + config.category.displayName)
        tooltip += LiteralText(YELLOW + config.category.details)
        // Rot
        if (config.category.canRot && state.displayRot) {
            breakLine(tooltip)
            tooltip += LiteralText(DARK_GREEN + "Rot: " + profile.rotProgress + "/" + config.rotState)
        }
        // Overdue
        if (config.category.canOverdue && state.displayOverdue) {
            breakLine(tooltip)
            tooltip += LiteralText(DARK_PURPLE + "Overdue: " + profile.overdueProgress + "/" + config.overdueState)
        }
        // Fridge
        if (config.category.canBePutInFridge && state.displayFridgeProperties) {
            breakLine(tooltip)
            tooltip += LiteralText(BLUE + "Is in fridge: " + profile.fridgeState.boolValue)
            tooltip += LiteralText(DARK_BLUE + "Fridge efficiency: " + config.fridgeEfficiency)
        }
    }
}