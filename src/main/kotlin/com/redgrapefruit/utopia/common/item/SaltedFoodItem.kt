package com.redgrapefruit.utopia.common.item

import com.redgrapefruit.utopia.common.core.FoodState

/**
 * A salted variant of a [FoodItem]
 */
class SaltedFoodItem(name: String) : FoodItem(name) {
    init {
        state = FoodState.SALTED
        isSalt = true
    }
}