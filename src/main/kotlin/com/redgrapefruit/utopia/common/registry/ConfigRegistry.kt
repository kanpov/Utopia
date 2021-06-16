package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.core.data.FoodCategory
import com.redgrapefruit.utopia.common.core.data.FoodConfig

/**
 * Contains all the food configs
 */
object ConfigRegistry {
    val ALMOND = FoodConfig(
        overdueSpeed = 7,
        overdueState = 100000,
        saltEfficiency = 4,
        category = FoodCategory.NUT
    )

    val ALMOND_BRITTLE = FoodConfig(
        overdueSpeed = 8,
        overdueState = 120000,
        fridgeEfficiency = 5,
        saltEfficiency = 2,
        category = FoodCategory.PRODUCT
    )

    val APPLE_JUICE = FoodConfig(
        overdueSpeed = 11,
        overdueState = 100000,
        fridgeEfficiency = 6,
        category = FoodCategory.PRODUCT
    )

    val APPLE_PIE = FoodConfig(
        overdueSpeed = 5,
        overdueState = 70000,
        fridgeEfficiency = 2,
        category = FoodCategory.PRODUCT
    )

    val APRICOT = FoodConfig(
        overdueSpeed = 9,
        overdueState = 135000,
        fridgeEfficiency = 5,
        saltEfficiency = 4,
        category = FoodCategory.FRUIT
    )

    val APRICOT_JAM = FoodConfig(
        overdueSpeed = 6,
        overdueState = 85000,
        fridgeEfficiency = 2,
        category = FoodCategory.PRODUCT
    )

    val ARTICHOKE = FoodConfig(
        overdueSpeed = 4,
        overdueState = 60000,
        fridgeEfficiency = 1,
        saltEfficiency = 2,
        category = FoodCategory.PLANT
    )

    val ARTICHOKE_DIP = FoodConfig(
        overdueSpeed = 5,
        overdueState = 80000,
        fridgeEfficiency = 2,
        saltEfficiency = 3,
        category = FoodCategory.PRODUCT
    )

    val ASPARAGUS = FoodConfig(
        overdueSpeed = 9,
        overdueState = 135000,
        fridgeEfficiency = 5,
        saltEfficiency = 4,
        category = FoodCategory.PLANT
    )

    val AVOCADO = FoodConfig(
        overdueSpeed = 8,
        overdueState = 115000,
        fridgeEfficiency = 6,
        saltEfficiency = 4,
        category = FoodCategory.FRUIT
    )

    val BAKED_BEANS = FoodConfig(
        overdueSpeed = 5,
        overdueState = 150000,
        fridgeEfficiency = 2,
        saltEfficiency = 1,
        category = FoodCategory.PLANT
    )

    val BANANA = FoodConfig(
        overdueSpeed = 7,
        overdueState = 120000,
        fridgeEfficiency = 4,
        category = FoodCategory.FRUIT
    )

    val BANANA_CREAM_PIE = FoodConfig(
        overdueSpeed = 9,
        overdueState = 140000,
        fridgeEfficiency = 5,
        category = FoodCategory.PRODUCT
    )

    val BANANA_NUT_BREAD = FoodConfig(
        overdueSpeed = 10,
        overdueState = 165000,
        fridgeEfficiency = 5,
        saltEfficiency = 7,
        category = FoodCategory.PRODUCT
    )

    val BARLEY = FoodConfig(
        overdueSpeed = 8,
        overdueState = 130000,
        fridgeEfficiency = 4,
        category = FoodCategory.PLANT
    )

    val BASIL = FoodConfig(
        overdueSpeed = 7,
        overdueState = 90000,
        fridgeEfficiency = 3,
        saltEfficiency = 4,
        category = FoodCategory.PLANT
    )

    val BEEF_JERKY = FoodConfig(
        rotSpeed = 8,
        rotState = 140000,
        fridgeEfficiency = 5,
        saltEfficiency = 3,
        category = FoodCategory.MEAT
    )

    val BEEF_WELLINGTON = FoodConfig(
        rotSpeed = 7,
        rotState = 150000,
        fridgeEfficiency = 4,
        saltEfficiency = 3,
        category = FoodCategory.MEAT
    )

    val BELLPEPPER = FoodConfig(
        overdueSpeed = 9,
        overdueState = 115000,
        fridgeEfficiency = 4,
        category = FoodCategory.VEGETABLE
    )

    val BLACKBEAN = FoodConfig(
        overdueSpeed = 6,
        overdueState = 70000,
        fridgeEfficiency = 2,
        saltEfficiency = 3,
        category = FoodCategory.PLANT
    )

    val BLACKBERRY = FoodConfig(
        overdueSpeed = 8,
        overdueState = 120000,
        fridgeEfficiency = 6,
        category = FoodCategory.BERRIES
    )

    val BLACKBERRY_JAM = FoodConfig(
        overdueSpeed = 9,
        overdueState = 160000,
        fridgeEfficiency = 5,
        category = FoodCategory.PRODUCT
    )

    val BLT = FoodConfig(
        overdueSpeed = 14,
        overdueState = 105000,
        fridgeEfficiency = 5,
        category = FoodCategory.PRODUCT
    )

    val BLUEBERRY = FoodConfig(
        overdueSpeed = 7,
        overdueState = 125000,
        fridgeEfficiency = 3,
        category = FoodCategory.BERRIES
    )

    val BLUEBERRY_JAM = FoodConfig(
        overdueSpeed = 9,
        overdueState = 145000,
        fridgeEfficiency = 5,
        category = FoodCategory.PRODUCT
    )

    val BROCCOLI = FoodConfig(
        overdueSpeed = 5,
        overdueState = 75000,
        fridgeEfficiency = 2,
        saltEfficiency = 3,
        category = FoodCategory.PLANT
    )

    val BROWNIES = FoodConfig(
        overdueSpeed = 12,
        overdueState = 130000,
        fridgeEfficiency = 5,
        category = FoodCategory.PRODUCT
    )

    val BURRITO = FoodConfig(
        overdueSpeed = 8,
        overdueState = 110000,
        fridgeEfficiency = 4,
        category = FoodCategory.PRODUCT
    )

    val BUTTER = FoodConfig(
        overdueSpeed = 9,
        overdueState = 80000,
        fridgeEfficiency = 6,
        category = FoodCategory.PRODUCT
    )

    val BUTTERED_TOAST = FoodConfig(
        overdueSpeed = 13,
        overdueState = 150000,
        fridgeEfficiency = 7,
        category = FoodCategory.PRODUCT
    )

    val CABBAGE = FoodConfig(
        overdueSpeed = 8,
        overdueState = 95000,
        fridgeEfficiency = 2,
        saltEfficiency = 5,
        category = FoodCategory.VEGETABLE
    )
}