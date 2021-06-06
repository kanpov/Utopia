package com.redgrapefruit.utopia.core

import com.redgrapefruit.utopia.UNUSED_PROPERTY
import com.redgrapefruit.utopia.module.Module
import com.redgrapefruit.utopia.module.SetModule

/**
 * A food config contains all unique information about a type of food
 */
@SetModule(Module.REALISM)
data class FoodConfig(
    /**
     * The state of the rot property in which the food is considered rotten
     */
    val rotState: Int = UNUSED_PROPERTY,
    /**
     * The amount of rot property that is incremented every tick of the game
     */
    val rotSpeed: Int = UNUSED_PROPERTY,
    /**
     * The state of the overdue property in which the food is considered overdue
     */
    val overdueState: Int = UNUSED_PROPERTY,
    /**
     * The amount of overdue property that is incremented every tick of the game
     */
    val overdueSpeed: Int = UNUSED_PROPERTY,
    /**
     * The efficiency of using salt on this food type
     */
    val saltEfficiency: Int = UNUSED_PROPERTY,
    /**
     * The efficiency of putting this food type inside of a fridge
     */
    val fridgeEfficiency: Int = UNUSED_PROPERTY,
    /**
     * The [FoodCategory] that this food type belongs to
     */
    val category: FoodCategory,
    /**
     * The [Set] of [FoodEffectConfig]s that this food type has. Has to be immutable
     */
    val effects: Set<FoodEffectConfig>
)
