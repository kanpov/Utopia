package com.redgrapefruit.utopia.registry

import com.redgrapefruit.utopia.util.IRegistry
import net.minecraft.item.Item

/**
 * Registry for drinks
 */
object DrinkRegistry : IRegistry {
    /**
     * Item => Thirst value map
     */
    private val THIRST_MAP: Map<Item, Int> = mapOf()

    fun getThirstFor(item: Item): Int = THIRST_MAP[item] ?: throw RuntimeException("Thirst not registered for ${item.translationKey}")

    override fun run() {

    }
}
