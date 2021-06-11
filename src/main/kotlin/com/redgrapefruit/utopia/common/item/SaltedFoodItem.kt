package com.redgrapefruit.utopia.common.item

import com.redgrapefruit.utopia.common.GROUP
import com.redgrapefruit.utopia.common.core.data.FoodConfig
import com.redgrapefruit.utopia.common.core.state.FoodState
import com.redgrapefruit.utopia.common.util.overrideComponentValues
import net.minecraft.item.FoodComponent

/**
 * A salted variant of a [FoodItem]
 */
class SaltedFoodItem : FoodItem {
    constructor(config: FoodConfig) : super(config) {
        state = FoodState.SALTED
        isSalt = true
    }

    constructor(config: FoodConfig, component: FoodComponent) : super(config, GROUP, {
        val builder = FoodComponent.Builder()

        overrideComponentValues(component, builder, 0, 0f)

        builder.build()
    }) {
        state = FoodState.SALTED
        isSalt = true
    }
}