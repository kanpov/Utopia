package com.redgrapefruit.utopia.registry

import com.redgrapefruit.utopia.MOD_ID
import com.redgrapefruit.utopia.core.RFoodCategory
import com.redgrapefruit.utopia.core.RFoodConfig
import com.redgrapefruit.utopia.item.RFoodItem
import com.redgrapefruit.utopia.item.ROverdueFoodItem
import com.redgrapefruit.utopia.item.RSaltedFoodItem
import com.redgrapefruit.utopia.module.Module
import com.redgrapefruit.utopia.module.ModuleFeature
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * Realism's item registry
 */
object RItemRegistry : ModuleFeature() {
    override val module: Module
        get() = Module.REALISM

    internal val TEMP_ALMOND_CONFIG = RFoodConfig(
        hunger = 3,
        saturationModifier = 1.4f,
        overdueSpeed = 800,
        overdueState = 100000,
        category = RFoodCategory.NUT,
        effects = emptySet()
    )

    // Overdue food
    val OVERDUE_ALMOND = ROverdueFoodItem(TEMP_ALMOND_CONFIG)

    // Rotten food

    // Salted food
    val SALTED_ALMOND = RSaltedFoodItem(TEMP_ALMOND_CONFIG)

    // Fresh food

    override fun run() {
        register("overdue_almond", OVERDUE_ALMOND)
        register("salted_almond", SALTED_ALMOND)
    }

    /**
     * Registers an item to Minecraft
     * @param name Item name
     * @param item Registered item
     */
    private fun register(name: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, name), item)
    }
}