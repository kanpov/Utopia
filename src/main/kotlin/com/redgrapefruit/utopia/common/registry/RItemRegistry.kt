package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.MOD_ID
import com.redgrapefruit.utopia.common.item.ROverdueFoodItem
import com.redgrapefruit.utopia.common.item.RSaltedFoodItem
import com.redgrapefruit.utopia.common.module.Module
import com.redgrapefruit.utopia.common.module.ModuleFeature
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * Realism's item registry
 */
object RItemRegistry : ModuleFeature {
    override val module: Module
        get() = Module.REALISM

    // Overdue food
    val OVERDUE_ALMOND = ROverdueFoodItem(RConfigRegistry.ALMOND)

    // Rotten food

    // Salted food
    val SALTED_ALMOND = RSaltedFoodItem(RConfigRegistry.ALMOND)

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