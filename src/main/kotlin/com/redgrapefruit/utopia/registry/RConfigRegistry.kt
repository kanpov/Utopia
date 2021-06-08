package com.redgrapefruit.utopia.registry

import com.redgrapefruit.utopia.core.data.RFoodCategory
import com.redgrapefruit.utopia.core.data.RFoodConfig

/**
 * Contains all the food configs
 */
object RConfigRegistry {
    val ALMOND = RFoodConfig(
        overdueSpeed = 800,
        overdueState = 100000,
        category = RFoodCategory.NUT,
        effects = emptySet()
    )
}