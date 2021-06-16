package com.redgrapefruit.utopia.common.core.data

import com.redgrapefruit.utopia.common.UNUSED_PROPERTY
import com.redgrapefruit.utopia.common.UNUSED_PROPERTY_FLOAT

/**
 * A food config contains all unique information about a type of food
 */
data class FoodConfig(
    /**
     * The hunger of this food type. Only used in new food
     */
    val hunger: Int = UNUSED_PROPERTY,
    /**
     * The saturation modifier of this food type. Only used in new food
     */
    val saturationModifier: Float = UNUSED_PROPERTY_FLOAT,
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
    val category: FoodCategory
)
