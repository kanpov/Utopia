package com.redgrapefruit.utopia.core

import com.redgrapefruit.utopia.item.ROverdueFoodItem
import com.redgrapefruit.utopia.item.RRottenFoodItem
import com.redgrapefruit.utopia.util.calculateOverdue
import com.redgrapefruit.utopia.util.calculateRot
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.world.World

object RFoodEngine {
    /**
     * Main block of logic that executes every tick the item is inside of a player's inventory
     *
     * @param config Linked [RFoodConfig]
     * @param profile Linked [RFoodProfile]
     * @param player Owner [PlayerEntity]
     * @param slot Inventory slot
     * @param world Current [World] instance
     * @param rottenVariant Rotten variant of the given item
     * @param overdueVariant Overdue variant of the given item
     */
    fun inventoryTick(
        config: RFoodConfig,
        profile: RFoodProfile,
        player: PlayerEntity,
        slot: Int,
        world: World,
        rottenVariant: RRottenFoodItem,
        overdueVariant: ROverdueFoodItem,
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
        if (profile.rotProgress >= config.rotState) {
            // Swap the item with its rotten variant and reset counter for the stack
            player.inventory.getStack(slot).decrement(1)
            player.inventory.offerOrDrop(world, ItemStack(rottenVariant))
            profile.rotProgress = 0
        }
        if (profile.overdueProgress >= config.overdueState) {
            // Swap the item with its overdue variant and reset counter for the stack
            player.inventory.getStack(slot).decrement(1)
            player.inventory.offerOrDrop(world, ItemStack(overdueVariant))
            profile.overdueProgress = 0
        }
    }
}