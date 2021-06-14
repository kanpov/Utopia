package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.core.data.FoodCategory
import com.redgrapefruit.utopia.common.core.data.FoodConfig
import com.redgrapefruit.utopia.common.core.data.FoodEffectConfig
import com.redgrapefruit.utopia.common.util.IntRange
import net.minecraft.entity.effect.StatusEffects

/**
 * Contains all the food configs
 */
object ConfigRegistry {
    val ALMOND = FoodConfig(
        overdueSpeed = 7,
        overdueState = 100000,
        saltEfficiency = 4,
        category = FoodCategory.NUT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.SPEED,
            durationRange = IntRange(100, 200),
            amplifier = 0,
            chance = 0.6f
        )
    )

    val ALMOND_BRITTLE = FoodConfig(
        overdueSpeed = 8,
        overdueState = 120000,
        fridgeEfficiency = 5,
        saltEfficiency = 2,
        category = FoodCategory.PRODUCT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.SPEED,
            durationRange = IntRange(200, 350),
            amplifierRange = IntRange(0, 2),
            chance = 0.8f
        )
    )

    val APPLE_JUICE = FoodConfig(
        overdueSpeed = 11,
        overdueState = 100000,
        fridgeEfficiency = 6,
        category = FoodCategory.PRODUCT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.REGENERATION,
            durationRange = IntRange(150, 300),
            amplifierRange = IntRange(0, 1),
            chance = 0.5f
        )
    )

    val APPLE_PIE = FoodConfig(
        overdueSpeed = 5,
        overdueState = 70000,
        fridgeEfficiency = 2,
        category = FoodCategory.PRODUCT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.REGENERATION,
            durationRange = IntRange(250, 400),
            amplifierRange = IntRange(1, 2),
            isAlwaysApplied = true
        )
    )

    val APRICOT = FoodConfig(
        overdueSpeed = 9,
        overdueState = 135000,
        fridgeEfficiency = 5,
        saltEfficiency = 4,
        category = FoodCategory.FRUIT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.ABSORPTION,
            durationRange = IntRange(200, 300),
            amplifierRange = IntRange(0, 1),
            chance = 0.65f
        )
    )

    val APRICOT_JAM = FoodConfig(
        overdueSpeed = 6,
        overdueState = 85000,
        fridgeEfficiency = 2,
        category = FoodCategory.PRODUCT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.ABSORPTION,
            durationRange = IntRange(350, 500),
            amplifierRange = IntRange(1, 3),
            chance = 0.9f
        )
    )

    val ARTICHOKE = FoodConfig(
        overdueSpeed = 4,
        overdueState = 60000,
        fridgeEfficiency = 1,
        saltEfficiency = 2,
        category = FoodCategory.PLANT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.RESISTANCE,
            durationRange = IntRange(150, 200),
            amplifier = 0,
            isAlwaysApplied = true
        )
    )

    val ARTICHOKE_DIP = FoodConfig(
        overdueSpeed = 5,
        overdueState = 80000,
        fridgeEfficiency = 2,
        saltEfficiency = 3,
        category = FoodCategory.PRODUCT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.RESISTANCE,
            durationRange = IntRange(250, 400),
            amplifierRange = IntRange(0, 1),
            chance = 0.85f
        )
    )

    val ASPARAGUS = FoodConfig(
        overdueSpeed = 9,
        overdueState = 135000,
        fridgeEfficiency = 5,
        saltEfficiency = 4,
        category = FoodCategory.PLANT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.SATURATION,
            durationRange = IntRange(200, 400),
            amplifierRange = IntRange(0, 2),
            isAlwaysApplied = true
        )
    )

    val AVOCADO = FoodConfig(
        overdueSpeed = 8,
        overdueState = 115000,
        fridgeEfficiency = 6,
        saltEfficiency = 4,
        category = FoodCategory.FRUIT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.SLOW_FALLING,
            durationRange = IntRange(250, 500),
            amplifierRange = IntRange(0, 1),
            chance = 0.45f
        )
    )

    val BAKED_BEANS = FoodConfig(
        overdueSpeed = 5,
        overdueState = 150000,
        fridgeEfficiency = 2,
        saltEfficiency = 1,
        category = FoodCategory.PLANT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.HERO_OF_THE_VILLAGE,
            durationRange = IntRange(400, 750),
            amplifierRange = IntRange(0, 2),
            chance = 0.9f
        )
    )

    val BANANA = FoodConfig(
        overdueSpeed = 7,
        overdueState = 120000,
        fridgeEfficiency = 4,
        category = FoodCategory.FRUIT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.FIRE_RESISTANCE,
            durationRange = IntRange(300, 600),
            amplifier = 0,
            chance = 0.65f
        )
    )

    val BANANA_CREAM_PIE = FoodConfig(
        overdueSpeed = 9,
        overdueState = 140000,
        fridgeEfficiency = 5,
        category = FoodCategory.PRODUCT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.FIRE_RESISTANCE,
            durationRange = IntRange(400, 750),
            amplifier = 0,
            isAlwaysApplied = true
        )
    )

    val BANANA_NUT_BREAD = FoodConfig(
        overdueSpeed = 10,
        overdueState = 165000,
        fridgeEfficiency = 5,
        saltEfficiency = 7,
        category = FoodCategory.PRODUCT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.FIRE_RESISTANCE,
            durationRange = IntRange(600, 900),
            amplifier = 0,
            chance = 0.8f
        )
    )

    val BARLEY = FoodConfig(
        overdueSpeed = 8,
        overdueState = 130000,
        fridgeEfficiency = 4,
        category = FoodCategory.PLANT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.WATER_BREATHING,
            durationRange = IntRange(500, 800),
            amplifier = 0,
            isAlwaysApplied = true
        )
    )

    val BASIL = FoodConfig(
        overdueSpeed = 7,
        overdueState = 90000,
        fridgeEfficiency = 3,
        saltEfficiency = 4,
        category = FoodCategory.PLANT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.INSTANT_HEALTH,
            durationRange = IntRange(25, 50),
            amplifier = 0,
            chance = 0.7f
        )
    )

    val BEEF_JERKY = FoodConfig(
        rotSpeed = 8,
        rotState = 140000,
        fridgeEfficiency = 5,
        saltEfficiency = 3,
        category = FoodCategory.MEAT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.LUCK,
            durationRange = IntRange(1500, 2000),
            amplifierRange = IntRange(0, 3),
            chance = 0.4f
        )
    )

    val BEEF_WELLINGTON = FoodConfig(
        rotSpeed = 7,
        rotState = 150000,
        fridgeEfficiency = 4,
        saltEfficiency = 3,
        category = FoodCategory.MEAT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.JUMP_BOOST,
            durationRange = IntRange(200, 400),
            amplifierRange = IntRange(1, 2),
            chance = 0.65f
        )
    )

    val BELLPEPPER = FoodConfig(
        overdueSpeed = 9,
        overdueState = 115000,
        fridgeEfficiency = 4,
        category = FoodCategory.VEGETABLE,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.INVISIBILITY,
            durationRange = IntRange(250, 550),
            amplifier = 0,
            isAlwaysApplied = true
        )
    )

    val BLACKBEAN = FoodConfig(
        overdueSpeed = 6,
        overdueState = 70000,
        fridgeEfficiency = 2,
        saltEfficiency = 3,
        category = FoodCategory.PLANT,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.DOLPHINS_GRACE,
            durationRange = IntRange(300, 400),
            amplifierRange = IntRange(0, 1),
            chance = 0.25f
        )
    )

    val BLACKBERRY = FoodConfig(
        overdueState = 8,
        overdueSpeed = 120000,
        fridgeEfficiency = 6,
        category = FoodCategory.BERRIES,
        effect = FoodEffectConfig(
            statusEffect = StatusEffects.CONDUIT_POWER,
            durationRange = IntRange(400, 800),
            amplifierRange = IntRange(0, 3),
            chance = 0.65f
        )
    )
}