package com.redgrapefruit.utopia.common.core.data

import com.redgrapefruit.utopia.common.UNUSED_PROPERTY
import com.redgrapefruit.utopia.common.UNUSED_PROPERTY_FLOAT

/**
 * A food config contains all unique information about a type of food.
 *
 * When creating a [FoodConfig], **use the DSL** ([config])
 */
data class FoodConfig(
    /**
     * The hunger of this food type. Only used in new food
     */
    var hunger: Int = UNUSED_PROPERTY,
    /**
     * The saturation modifier of this food type. Only used in new food
     */
    var saturationModifier: Float = UNUSED_PROPERTY_FLOAT,
    /**
     * The state of the rot property in which the food is considered rotten
     */
    var rotState: Int = UNUSED_PROPERTY,
    /**
     * The amount of rot property that is incremented every tick of the game
     */
    var rotSpeed: Int = UNUSED_PROPERTY,
    /**
     * The state of the overdue property in which the food is considered overdue
     */
    var overdueState: Int = UNUSED_PROPERTY,
    /**
     * The amount of overdue property that is incremented every tick of the game
     */
    var overdueSpeed: Int = UNUSED_PROPERTY,
    /**
     * The efficiency of using salt on this food type
     */
    var saltEfficiency: Int = UNUSED_PROPERTY,
    /**
     * The efficiency of putting this food type inside of a fridge
     */
    var fridgeEfficiency: Int = UNUSED_PROPERTY,
    /**
     * The [FoodCategory] that this food type belongs to
     */
    var category: FoodCategory = FoodCategory.MISCELLANEOUS
)

// DSL

fun config(init: FoodConfig.() -> Unit): FoodConfig {
    val instance = FoodConfig()
    instance.init()
    return instance
}
