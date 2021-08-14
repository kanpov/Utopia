package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.core.FoodState

/**
 * A salted variant of a [FoodItem]
 */
class SaltedFoodItem(name: String) : FoodItem(name) {
    init {
        state = FoodState.SALTED
        isSalt = true
    }
}