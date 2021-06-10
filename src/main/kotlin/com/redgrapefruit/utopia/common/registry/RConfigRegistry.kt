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
        saltEfficiency = 4,
        category = RFoodCategory.NUT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.SPEED,
            durationRange = RIntRange(100, 200),
            amplifier = 0,
            chance = 0.6f
        )
    )

    val ALMOND_BRITTLE = RFoodConfig(
        overdueSpeed = 8,
        overdueState = 120000,
        fridgeEfficiency = 5,
        saltEfficiency = 2,
        category = RFoodCategory.PRODUCT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.SPEED,
            durationRange = RIntRange(200, 350),
            amplifierRange = RIntRange(0, 2),
            chance = 0.8f
        )
    )

    val APPLE_JUICE = RFoodConfig(
        overdueSpeed = 11,
        overdueState = 100000,
        fridgeEfficiency = 6,
        category = RFoodCategory.PRODUCT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.REGENERATION,
            durationRange = RIntRange(150, 300),
            amplifierRange = RIntRange(0, 1),
            chance = 0.5f
        )
    )

    val APPLE_PIE = RFoodConfig(
        overdueSpeed = 5,
        overdueState = 70000,
        fridgeEfficiency = 2,
        category = RFoodCategory.PRODUCT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.REGENERATION,
            durationRange = RIntRange(250, 400),
            amplifierRange = RIntRange(1, 2),
            isAlwaysApplied = true
        )
    )

    val APRICOT = RFoodConfig(
        overdueSpeed = 9,
        overdueState = 135000,
        fridgeEfficiency = 5,
        saltEfficiency = 4,
        category = RFoodCategory.FRUIT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.ABSORPTION,
            durationRange = RIntRange(200, 300),
            amplifierRange = RIntRange(0, 1),
            chance = 0.65f
        )
    )

    val APRICOT_JAM = RFoodConfig(
        overdueSpeed = 6,
        overdueState = 85000,
        fridgeEfficiency = 2,
        category = RFoodCategory.PRODUCT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.ABSORPTION,
            durationRange = RIntRange(350, 500),
            amplifierRange = RIntRange(1, 3),
            chance = 0.9f
        )
    )

    val ARTICHOKE = RFoodConfig(
        overdueSpeed = 4,
        overdueState = 60000,
        fridgeEfficiency = 1,
        saltEfficiency = 2,
        category = RFoodCategory.PLANT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.RESISTANCE,
            durationRange = RIntRange(150, 200),
            amplifier = 0,
            isAlwaysApplied = true
        )
    )

    val ARTICHOKE_DIP = RFoodConfig(
        overdueSpeed = 5,
        overdueState = 80000,
        fridgeEfficiency = 2,
        saltEfficiency = 3,
        category = RFoodCategory.PRODUCT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.RESISTANCE,
            durationRange = RIntRange(250, 400),
            amplifierRange = RIntRange(0, 1),
            chance = 0.85f
        )
    )

    val ASPARAGUS = RFoodConfig(
        overdueSpeed = 9,
        overdueState = 135000,
        fridgeEfficiency = 5,
        saltEfficiency = 4,
        category = RFoodCategory.PLANT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.SATURATION,
            durationRange = RIntRange(200, 400),
            amplifierRange = RIntRange(0, 2),
            isAlwaysApplied = true
        )
    )

    val AVOCADO = RFoodConfig(
        overdueSpeed = 8,
        overdueState = 115000,
        fridgeEfficiency = 6,
        saltEfficiency = 4,
        category = RFoodCategory.FRUIT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.SLOW_FALLING,
            durationRange = RIntRange(250, 500),
            amplifierRange = RIntRange(0, 1),
            chance = 0.45f
        )
    )

    val BAKED_BEANS = RFoodConfig(
        overdueSpeed = 5,
        overdueState = 150000,
        fridgeEfficiency = 2,
        saltEfficiency = 1,
        category = RFoodCategory.PLANT,
        effect = RFoodEffectConfig(
            statusEffect = StatusEffects.HERO_OF_THE_VILLAGE,
            durationRange = RIntRange(400, 750),
            amplifierRange = RIntRange(0, 2),
            chance = 0.9f
        )
    )
}