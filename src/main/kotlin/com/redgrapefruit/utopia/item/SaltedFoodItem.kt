package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.core.FoodState

/**
 * A salted variant of a [AdvancedFoodItem]
 */
class SaltedFoodItem(name: String) : AdvancedFoodItem(name) {
    init {
        state = FoodState.SALTED
        isSalt = true
    }
}