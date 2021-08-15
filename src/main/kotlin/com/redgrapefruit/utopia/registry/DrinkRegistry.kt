package com.redgrapefruit.utopia.registry

import com.redgrapefruit.utopia.EDIBLE_3
import com.redgrapefruit.utopia.MOD_ID
import com.redgrapefruit.utopia.item.RancidDrinkItem
import com.redgrapefruit.utopia.util.IRegistry
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * Registry for drinks
 */
object DrinkRegistry : IRegistry {
    val RANCID_APPLE_JUICE = RancidDrinkItem(EDIBLE_3, 7, 85000)

    /**
     * Item => Thirst value map
     */
    private val THIRST_MAP: Map<Item, Int> = mapOf(
        RANCID_APPLE_JUICE to 1)

    fun getThirstFor(item: Item): Int = THIRST_MAP[item] ?: throw RuntimeException("Thirst not registered for ${item.translationKey}")

    override fun run() {
        register("rancid_apple_juice", RANCID_APPLE_JUICE)
    }

    private fun register(name: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, name), item)
    }
}
