package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.core.FoodCategory
import com.redgrapefruit.utopia.common.core.config

/**
 * Contains all the food configs
 */
object ConfigRegistry {
    val ALMOND = config {
        overdueSpeed = 7
        overdueState = 100000
        saltEfficiency = 4
        category = FoodCategory.NUT
    }

    val ALMOND_BRITTLE = config {
        overdueSpeed = 8
        overdueState = 120000
        fridgeEfficiency = 5
        saltEfficiency = 2
        category = FoodCategory.PRODUCT
    }

    val APPLE_JUICE = config {
        overdueSpeed = 11
        overdueState = 100000
        fridgeEfficiency = 6
        category = FoodCategory.PRODUCT
    }

    val APPLE_PIE = config {
        overdueSpeed = 5
        overdueState = 70000
        fridgeEfficiency = 2
        category = FoodCategory.PRODUCT
    }

    val APRICOT = config {
        overdueSpeed = 9
        overdueState = 135000
        fridgeEfficiency = 5
        saltEfficiency = 4
        category = FoodCategory.FRUIT
    }

    val APRICOT_JAM = config {
        overdueSpeed = 6
        overdueState = 85000
        fridgeEfficiency = 2
        category = FoodCategory.PRODUCT
    }

    val ARTICHOKE = config {
        overdueSpeed = 4
        overdueState = 60000
        fridgeEfficiency = 1
        saltEfficiency = 2
        category = FoodCategory.PLANT
    }

    val ARTICHOKE_DIP = config {
        overdueSpeed = 5
        overdueState = 80000
        fridgeEfficiency = 2
        saltEfficiency = 3
        category = FoodCategory.PRODUCT
    }

    val ASPARAGUS = config {
        overdueSpeed = 9
        overdueState = 135000
        fridgeEfficiency = 5
        saltEfficiency = 4
        category = FoodCategory.PLANT
    }

    val AVOCADO = config {
        overdueSpeed = 8
        overdueState = 115000
        fridgeEfficiency = 6
        saltEfficiency = 4
        category = FoodCategory.FRUIT
    }

    val BAKED_BEANS = config {
        overdueSpeed = 5
        overdueState = 150000
        fridgeEfficiency = 2
        saltEfficiency = 1
        category = FoodCategory.PLANT
    }

    val BANANA = config {
        overdueSpeed = 7
        overdueState = 120000
        fridgeEfficiency = 4
        category = FoodCategory.FRUIT
    }

    val BANANA_CREAM_PIE = config {
        overdueSpeed = 9
        overdueState = 140000
        fridgeEfficiency = 5
        category = FoodCategory.PRODUCT
    }

    val BANANA_NUT_BREAD = config {
        overdueSpeed = 10
        overdueState = 165000
        fridgeEfficiency = 5
        saltEfficiency = 7
        category = FoodCategory.PRODUCT
    }

    val BARLEY = config {
        overdueSpeed = 8
        overdueState = 130000
        fridgeEfficiency = 4
        category = FoodCategory.PLANT
    }

    val BASIL = config {
        overdueSpeed = 7
        overdueState = 90000
        fridgeEfficiency = 3
        saltEfficiency = 4
        category = FoodCategory.PLANT
    }

    val BEEF_JERKY = config {
        rotSpeed = 8
        rotState = 140000
        fridgeEfficiency = 5
        saltEfficiency = 3
        category = FoodCategory.MEAT
    }

    val BEEF_WELLINGTON = config {
        rotSpeed = 7
        rotState = 150000
        fridgeEfficiency = 4
        saltEfficiency = 3
        category = FoodCategory.MEAT
    }

    val BELLPEPPER = config {
        overdueSpeed = 9
        overdueState = 115000
        fridgeEfficiency = 4
        category = FoodCategory.VEGETABLE
    }

    val BLACKBEAN = config {
        overdueSpeed = 6
        overdueState = 70000
        fridgeEfficiency = 2
        saltEfficiency = 3
        category = FoodCategory.PLANT
    }

    val BLACKBERRY = config {
        overdueSpeed = 8
        overdueState = 120000
        fridgeEfficiency = 6
        category = FoodCategory.BERRIES
    }

    val BLACKBERRY_JAM = config {
        overdueSpeed = 9
        overdueState = 160000
        fridgeEfficiency = 5
        category = FoodCategory.PRODUCT
    }

    val BLT = config {
        overdueSpeed = 14
        overdueState = 105000
        fridgeEfficiency = 5
        category = FoodCategory.PRODUCT
    }

    val BLUEBERRY = config {
        overdueSpeed = 7
        overdueState = 125000
        fridgeEfficiency = 3
        category = FoodCategory.BERRIES
    }

    val BLUEBERRY_JAM = config {
        overdueSpeed = 9
        overdueState = 145000
        fridgeEfficiency = 5
        category = FoodCategory.PRODUCT
    }

    val BROCCOLI = config {
        overdueSpeed = 5
        overdueState = 75000
        fridgeEfficiency = 2
        saltEfficiency = 3
        category = FoodCategory.PLANT
    }

    val BROWNIES = config {
        overdueSpeed = 12
        overdueState = 130000
        fridgeEfficiency = 5
        category = FoodCategory.PRODUCT
    }

    val BURRITO = config {
        overdueSpeed = 8
        overdueState = 110000
        fridgeEfficiency = 4
        category = FoodCategory.PRODUCT
    }

    val BUTTER = config {
        overdueSpeed = 9
        overdueState = 80000
        fridgeEfficiency = 6
        category = FoodCategory.PRODUCT
    }

    val BUTTERED_TOAST = config {
        overdueSpeed = 13
        overdueState = 150000
        fridgeEfficiency = 7
        category = FoodCategory.PRODUCT
    }

    val CABBAGE = config {
        overdueSpeed = 8
        overdueState = 95000
        fridgeEfficiency = 2
        saltEfficiency = 5
        category = FoodCategory.VEGETABLE
    }

    val CAESAR_SALAD = config {
        overdueSpeed = 9
        overdueState = 80000
        fridgeEfficiency = 6
        saltEfficiency = 2
        category = FoodCategory.PRODUCT
    }

    val CANDIED_NUTS = config {
        overdueSpeed = 15
        overdueState = 100000
        fridgeEfficiency = 6
        category = FoodCategory.PRODUCT
    }

    val CANDY_CORN = config {
        overdueSpeed = 18
        overdueState = 130000
        fridgeEfficiency = 11
        category = FoodCategory.PRODUCT
    }

    val CARAMEL = config {
        overdueSpeed = 14
        overdueState = 180000
        fridgeEfficiency = 8
        category = FoodCategory.PRODUCT
    }

    val CANTALOUPE = config {
        overdueSpeed = 6
        overdueState = 135000
        fridgeEfficiency = 4
        saltEfficiency = 1
        category = FoodCategory.FRUIT
    }

    val CARNITAS = config {
        overdueSpeed = 8
        overdueState = 110000
        fridgeEfficiency = 3
        saltEfficiency = 5
        category = FoodCategory.PRODUCT
    }

    val CASHEW = config {
        overdueSpeed = 4
        overdueState = 210000
        fridgeEfficiency = 1
        saltEfficiency = 2
        category = FoodCategory.NUT
    }

    val CASHEW_CHICKEN = config {
        overdueSpeed = 6
        overdueState = 130000
        fridgeEfficiency = 4
        saltEfficiency = 1
        category = FoodCategory.PRODUCT
    }

    val CAULIFLOWER = config {
        overdueSpeed = 7
        overdueState = 105000
        fridgeEfficiency = 4
        saltEfficiency = 2
        category = FoodCategory.PLANT
    }

    val CELERY = config {
        overdueSpeed = 11
        overdueState = 125000
        fridgeEfficiency = 6
        saltEfficiency = 4
        category = FoodCategory.PLANT
    }
}