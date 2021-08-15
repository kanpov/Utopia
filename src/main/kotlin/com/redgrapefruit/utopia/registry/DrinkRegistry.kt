package com.redgrapefruit.utopia.registry

import net.minecraft.item.Item

/**
 * Registry for drinks
 */
object DrinkRegistry {
    /**
     * Item => Thirst value map
     */
    private val THIRST_MAP: Map<Item, Int> = mapOf()

    fun getThirstFor(item: Item): Int = THIRST_MAP[item] ?: throw RuntimeException("Thirst not registered for ${item.translationKey}")

    fun run() {

    }
}
