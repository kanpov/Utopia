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
    override val module: Module = Module.REALISM
    override val isClientSide: Boolean = false

    // Overdue food
    val OVERDUE_ALMOND = ROverdueFoodItem(RConfigRegistry.ALMOND)
    val OVERDUE_ALMOND_BRITTLE = ROverdueFoodItem(RConfigRegistry.ALMOND_BRITTLE)
    val OVERDUE_APPLE_JUICE = ROverdueFoodItem(RConfigRegistry.APPLE_JUICE)
    val OVERDUE_APPLE_PIE = ROverdueFoodItem(RConfigRegistry.APPLE_PIE)
    val OVERDUE_APRICOT = ROverdueFoodItem(RConfigRegistry.APRICOT)

    // Rotten food

    // Salted food
    val SALTED_ALMOND = RSaltedFoodItem(RConfigRegistry.ALMOND)
    val SALTED_ALMOND_BRITTLE = RSaltedFoodItem(RConfigRegistry.ALMOND_BRITTLE)
    val SALTED_APRICOT = RSaltedFoodItem(RConfigRegistry.APRICOT)

    // Fresh food

    override fun run() {
        register("overdue_almond", OVERDUE_ALMOND)
        register("overdue_almond_brittle", OVERDUE_ALMOND_BRITTLE)
        register("overdue_apple_juice", OVERDUE_APPLE_JUICE)
        register("overdue_apple_pie", OVERDUE_APPLE_PIE)
        register("overdue_apricot", OVERDUE_APRICOT)
        register("salted_almond", SALTED_ALMOND)
        register("salted_almond_brittle", SALTED_ALMOND_BRITTLE)
        register("salted_apricot", SALTED_APRICOT)
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