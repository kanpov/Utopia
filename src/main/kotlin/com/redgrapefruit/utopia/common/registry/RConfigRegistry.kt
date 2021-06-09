package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.core.data.RFoodCategory
import com.redgrapefruit.utopia.common.core.data.RFoodConfig
import com.redgrapefruit.utopia.common.core.data.RFoodEffectConfig
import com.redgrapefruit.utopia.common.util.RIntRange
import net.minecraft.entity.effect.StatusEffects

/**
 * Contains all the food configs
 */
object RConfigRegistry {
    val ALMOND = RFoodConfig(
        overdueSpeed = 7,
        overdueState = 100000,
        category = RFoodCategory.NUT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.SPEED,
            durationRange = RIntRange(100, 200),
            amplifier = 0,
            chance = 0.6f
        )
    )
}