package com.redgrapefruit.utopia.common.item

import com.redgrapefruit.utopia.common.GROUP
import com.redgrapefruit.utopia.common.core.data.RFoodConfig
import com.redgrapefruit.utopia.common.core.state.RFoodState
import com.redgrapefruit.utopia.common.util.overrideComponentValues
import net.minecraft.item.FoodComponent

/**
 * A salted variant of a [RFoodItem]
 */
class RSaltedFoodItem : RFoodItem {
    constructor(config: RFoodConfig) : super(config) {
        state = RFoodState.SALTED
        isSalt = true
    }

    constructor(config: RFoodConfig, component: FoodComponent) : super(config, GROUP, {
        val builder = FoodComponent.Builder()

        overrideComponentValues(component, builder, 0, 0f)

        builder.build()
    }) {
        state = RFoodState.SALTED
        isSalt = true
    }
}