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
        category = FoodCategory.HUMAN_MADE
    }

    val APPLE_JUICE = config {
        overdueSpeed = 11
        overdueState = 100000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val APPLE_PIE = config {
        overdueSpeed = 5
        overdueState = 70000
        fridgeEfficiency = 2
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
    }

    val BANANA_NUT_BREAD = config {
        overdueSpeed = 10
        overdueState = 165000
        fridgeEfficiency = 5
        saltEfficiency = 7
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
    }

    val BLT = config {
        overdueSpeed = 14
        overdueState = 105000
        fridgeEfficiency = 5
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
    }

    val BURRITO = config {
        overdueSpeed = 8
        overdueState = 110000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val BUTTER = config {
        overdueSpeed = 9
        overdueState = 80000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val BUTTERED_TOAST = config {
        overdueSpeed = 13
        overdueState = 150000
        fridgeEfficiency = 7
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
    }

    val CANDIED_NUTS = config {
        overdueSpeed = 15
        overdueState = 100000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val CANDY_CORN = config {
        overdueSpeed = 18
        overdueState = 130000
        fridgeEfficiency = 11
        category = FoodCategory.HUMAN_MADE
    }

    val CARAMEL = config {
        overdueSpeed = 14
        overdueState = 180000
        fridgeEfficiency = 8
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
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
        category = FoodCategory.HUMAN_MADE
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

    val CHEESE = config {
        overdueSpeed = 5
        overdueState = 90000
        fridgeEfficiency = 2
        category = FoodCategory.DAIRY
    }

    val CHEESE_CAKE = config {
        overdueSpeed = 8
        overdueState = 120000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val CHEESE_PIZZA = config {
        overdueSpeed = 15
        overdueState = 110000
        fridgeEfficiency = 13
        category = FoodCategory.HUMAN_MADE
    }

    val CHEESEBURGER = config {
        overdueSpeed = 21
        overdueState = 125000
        fridgeEfficiency = 9
        category = FoodCategory.HUMAN_MADE
    }

    val CHERRY = config {
        overdueSpeed = 9
        overdueState = 85000
        fridgeEfficiency = 4
        category = FoodCategory.BERRIES
    }

    val CHERRY_JAM = config {
        overdueSpeed = 7
        overdueState = 120000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val CHERRY_PIE = config {
        overdueSpeed = 9
        overdueState = 135000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val CHICKEN_AND_DUMPLINGS = config {
        overdueSpeed = 16
        overdueState = 110000
        fridgeEfficiency = 14
        category = FoodCategory.HUMAN_MADE
    }

    val CHICKEN_AND_NOODLES = config {
        overdueSpeed = 15
        overdueState = 120000
        fridgeEfficiency = 12
        category = FoodCategory.HUMAN_MADE
    }

    val CHICKEN_AND_RICE = config {
        overdueSpeed = 18
        overdueState = 100000
        fridgeEfficiency = 14
        category = FoodCategory.HUMAN_MADE
    }

    val CHILE_PEPPER = config {
        overdueSpeed = 5
        overdueState = 140000
        fridgeEfficiency = 2
        category = FoodCategory.VEGETABLE
    }

    val CHILI_RELLENO = config {
        overdueSpeed = 11
        overdueState = 90000
        fridgeEfficiency = 5
        category = FoodCategory.HUMAN_MADE
    }

    val CHIMICHANGA = config {
        overdueSpeed = 9
        overdueState = 175000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val CHOCOLATE = config {
        overdueSpeed = 5
        overdueState = 210000
        fridgeEfficiency = 2
        category = FoodCategory.HUMAN_MADE
    }

    val CHOCOLATE_MILKSHAKE = config {
        overdueSpeed = 7
        overdueState = 95000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val CINNAMON = config {
        overdueSpeed = 3
        overdueState = 115000
        fridgeEfficiency = 1
        saltEfficiency = 1
        category = FoodCategory.SPICE
    }

    val COCONUT = config {
        overdueSpeed = 4
        overdueState = 130000
        fridgeEfficiency = 2
        category = FoodCategory.PLANT
    }

    val COFFEE = config {
        overdueSpeed = 25
        overdueState = 100000
        fridgeEfficiency = 0
        category = FoodCategory.MISCELLANEOUS
    }

    val COFFEE_BEANS = config {
        overdueSpeed = 7
        overdueState = 130000
        fridgeEfficiency = 5
        category = FoodCategory.PLANT
    }

    val CORN = config {
        overdueSpeed = 13
        overdueState = 150000
        fridgeEfficiency = 7
        category = FoodCategory.PLANT
    }

    val CORNISH_PASTY = config {
        overdueSpeed = 8
        overdueState = 110000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val CRANBERRY = config {
        overdueSpeed = 9
        overdueState = 125000
        fridgeEfficiency = 4
        category = FoodCategory.BERRIES
    }

    val CRANBERRY_JUICE = config {
        overdueSpeed = 8
        overdueState = 165000
        fridgeEfficiency = 5
        category = FoodCategory.HUMAN_MADE
    }

    val CREMA = config {
        overdueSpeed = 12
        overdueState = 85000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val CUCUMBER = config {
        overdueSpeed = 8
        overdueState = 165000
        fridgeEfficiency = 3
        category = FoodCategory.VEGETABLE
    }

    val CUCUMBER_SALAD = config {
        overdueSpeed = 10
        overdueState = 145500
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val CURRANT = config {
        overdueSpeed = 8
        overdueState = 140000
        fridgeEfficiency = 2
        category = FoodCategory.BERRIES
    }

    val DATE = config {
        overdueSpeed = 11
        overdueState = 125500
        fridgeEfficiency = 8
        category = FoodCategory.FRUIT
    }

    val DOUGH = config {
        overdueSpeed = 8
        overdueState = 90000
        fridgeEfficiency = 2
        category = FoodCategory.MISCELLANEOUS
    }

    val DOUGHNUT = config {
        overdueSpeed = 11
        overdueState = 105000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val DRAGONFRUIT = config {
        overdueSpeed = 7
        overdueState = 130000
        fridgeEfficiency = 4
        category = FoodCategory.FRUIT
    }

    val EGG_ROLL = config {
        overdueSpeed = 9
        overdueState = 75000
        fridgeEfficiency = 5
        saltEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val EGGPLANT = config {
        overdueSpeed = 6
        overdueState = 110000
        fridgeEfficiency = 3
        saltEfficiency = 1
        category = FoodCategory.PLANT
    }

    val ELDERBERRY = config {
        overdueSpeed = 8
        overdueState = 120000
        fridgeEfficiency = 5
        category = FoodCategory.BERRIES
    }

    val ELDERBERRY_JAM = config {
        overdueSpeed = 5
        overdueState = 215000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val ENCHILADA = config {
        overdueSpeed = 14
        overdueState = 100000
        fridgeEfficiency = 7
        category = FoodCategory.HUMAN_MADE
    }

    val ETON_MESS = config {
        overdueSpeed = 9
        overdueState = 150000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val FAJITAS = config {
        overdueSpeed = 7
        overdueState = 145000
        fridgeEfficiency = 5
        category = FoodCategory.HUMAN_MADE
    }

    val FIG = config {
        overdueSpeed = 8
        overdueState = 90000
        fridgeEfficiency = 4
        saltEfficiency = 2
        category = FoodCategory.FRUIT
    }

    val FIGGY_PUDDING = config {
        overdueSpeed = 11
        overdueState = 140000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val FISH_AND_CHIPS = config {
        overdueSpeed = 8
        overdueState = 95000
        fridgeEfficiency = 3
        saltEfficiency = 5
        category = FoodCategory.HUMAN_MADE
    }

    val FLOUR = config {
        overdueSpeed = 9
        overdueState = 110000
        fridgeEfficiency = 7
        category = FoodCategory.MISCELLANEOUS
    }

    val FRENCH_FRIES = config {
        overdueSpeed = 13
        overdueState = 80000
        fridgeEfficiency = 6
        saltEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val FRIED_CHICKEN = config {
        rotSpeed = 5
        rotState = 180000
        fridgeEfficiency = 2
        saltEfficiency = 1
        category = FoodCategory.MEAT
    }

    val FRUIT_SALAD = config {
        overdueSpeed = 6
        overdueState = 105000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val FRUIT_SMOOTHIE = config {
        overdueSpeed = 7
        overdueSpeed = 100000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val GARLIC = config {
        overdueSpeed = 9
        overdueSpeed = 115000
        fridgeEfficiency = 5
        saltEfficiency = 3
        category = FoodCategory.PLANT
    }

    val GINGER = config {
        overdueSpeed = 8
        overdueState = 185000
        fridgeEfficiency = 1
        category = FoodCategory.SPICE
    }

    val GRAPE = config {
        overdueSpeed = 13
        overdueState = 110000
        fridgeEfficiency = 5
        category = FoodCategory.FRUIT
    }

    val GRAPE_JAM = config {
        overdueSpeed = 9
        overdueState = 120000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val GRAPEFRUIT = config {
        overdueSpeed = 11
        overdueState = 80000
        fridgeEfficiency = 5
        category = FoodCategory.FRUIT
    }

    val GREENBEAN = config {
        overdueSpeed = 7
        overdueState = 125000
        fridgeEfficiency = 3
        saltEfficiency = 1
        category = FoodCategory.PLANT
    }

    val GREENONION = config {
        overdueSpeed = 8
        overdueState = 90000
        fridgeEfficiency = 4
        category = FoodCategory.VEGETABLE
    }

    val GRILLED_CHEESE = config {
        overdueSpeed = 6
        overdueSpeed = 80000
        fridgeEfficiency = 2
        category = FoodCategory.HUMAN_MADE
    }

    val HAM_SANDWICH = config {
        overdueSpeed = 9
        overdueState = 70000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val HAMBURGER = config {
        overdueSpeed = 11
        overdueState = 60000
        fridgeEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val HOPS = config {
        overdueSpeed = 4
        overdueState = 65000
        fridgeEfficiency = 1
        category = FoodCategory.MISCELLANEOUS
    }

    val HORCHATA = config {
        overdueSpeed = 9
        overdueState = 140000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val KALE = config {
        overdueSpeed = 6
        overdueState = 115000
        fridgeEfficiency = 2
        category = FoodCategory.PLANT
    }

    val KALE_CHIPS = config {
        overdueSpeed = 8
        overdueState = 95000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val KALE_SMOOTHIE = config {
        overdueSpeed = 5
        overdueState = 105000
        fridgeEfficiency = 2
        category = FoodCategory.HUMAN_MADE
    }

    val KIWI = config {
        overdueSpeed = 7
        overdueState = 135000
        fridgeEfficiency = 4
        category = FoodCategory.VEGETABLE
    }

    val KUMQUAT = config {
        overdueSpeed = 6
        overdueState = 100000
        fridgeEfficiency = 2
        category = FoodCategory.FRUIT
    }

    val LEAFY_SALAD = config {
        overdueSpeed = 8
        overdueState = 85000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val LEEK = config {
        overdueSpeed = 6
        overdueState = 125000
        fridgeEfficiency = 3
        category = FoodCategory.PLANT
    }

    val LEEK_SOUP = config {
        overdueSpeed = 8
        overdueState = 100000
        fridgeEfficiency = 5
        category = FoodCategory.HUMAN_MADE
    }

    val LEMON = config {
        overdueSpeed = 3
        overdueState = 145000
        fridgeEfficiency = 1
        category = FoodCategory.FRUIT
    }

    val LEMON_CHICKEN = config {
        rotSpeed = 6
        rotState = 160000
        fridgeEfficiency = 2
        category = FoodCategory.MEAT
    }

    val LEMONADE = config {
        overdueSpeed = 10
        overdueState = 140000
        fridgeEfficiency = 7
        category = FoodCategory.HUMAN_MADE
    }

    val LETTUCE = config {
        overdueSpeed = 7
        overdueState = 90000
        fridgeEfficiency = 2
        category = FoodCategory.PLANT
    }

    val LIME = config {
        overdueSpeed = 5
        overdueState = 110000
        fridgeEfficiency = 2
        category = FoodCategory.FRUIT
    }

    val LIMEADE = config {
        overdueSpeed = 6
        overdueState = 95000
        fridgeEfficiency = 1
        category = FoodCategory.HUMAN_MADE
    }

    val MANGO = config {
        overdueSpeed = 8
        overdueState = 125000
        fridgeEfficiency = 3
        category = FoodCategory.FRUIT
    }

    val MANGO_ICE_CREAM = config {
        overdueSpeed = 9
        overdueState = 65000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val MEAD = config {
        overdueSpeed = 6
        overdueState = 195000
        fridgeEfficiency = 2
        category = FoodCategory.HUMAN_MADE
    }

    val MELON_JUICE = config {
        overdueSpeed = 8
        overdueState = 125000
        fridgeEfficiency = 5
        category = FoodCategory.HUMAN_MADE
    }

    val MILK_BOTTLE = config {
        overdueSpeed = 15
        overdueState = 165000
        fridgeEfficiency = 8
        category = FoodCategory.DAIRY
    }

    val MOLASSES = config {
        overdueSpeed = 5
        overdueState = 190000
        fridgeEfficiency = 2
        category = FoodCategory.MISCELLANEOUS
    }

    val MUSTARD = config {
        overdueSpeed = 8
        overdueState = 225000
        fridgeEfficiency = 4
        category = FoodCategory.SPICE
    }

    val NECTARINE = config {
        overdueSpeed = 6
        overdueState = 110000
        fridgeEfficiency = 4
        category = FoodCategory.FRUIT
    }

    val NOODLE = config {
        overdueSpeed = 6
        overdueState = 145000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val NOUGAT = config {
        overdueSpeed = 7
        overdueState = 250000
        fridgeEfficiency = 1
        category = FoodCategory.HUMAN_MADE
    }

    val NUTMEG = config {
        overdueSpeed = 8
        overdueState = 150000
        fridgeEfficiency = 3
        saltEfficiency = 4
        category = FoodCategory.NUT
    }

    val NUTTY_COOKIE = config {
        overdueSpeed = 6
        overdueState = 125000
        fridgeEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val OAT = config {
        overdueSpeed = 11
        overdueState = 175000
        fridgeEfficiency = 6
        saltEfficiency = 4
        category = FoodCategory.HUMAN_MADE
    }

    val OATMEAL = config {
        overdueSpeed = 9
        overdueState = 165000
        fridgeEfficiency = 5
        category = FoodCategory.HUMAN_MADE
    }

    val OLIVE = config {
        overdueSpeed = 5
        overdueState = 190000
        fridgeEfficiency = 3
        saltEfficiency = 2
        category = FoodCategory.VEGETABLE
    }

    val OLIVE_OIL = config {
        overdueSpeed = 7
        overdueState = 150000
        fridgeEfficiency = 2
        category = FoodCategory.MISCELLANEOUS
    }

    val ONION = config {
        overdueSpeed = 10
        overdueState = 130000
        fridgeEfficiency = 5
        category = FoodCategory.VEGETABLE
    }

    val ONION_RINGS = config {
        overdueSpeed = 16
        overdueState = 100000
        fridgeEfficiency = 11
        saltEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val ORANGE = config {
        overdueSpeed = 7
        overdueState = 125000
        fridgeEfficiency = 4
        category = FoodCategory.VEGETABLE
    }

    val ORANGE_JUICE = config {
        overdueSpeed = 11
        overdueState = 135000
        fridgeEfficiency = 8
        category = FoodCategory.HUMAN_MADE
    }

    val PAPRIKA = config {
        overdueSpeed = 7
        overdueState = 155000
        fridgeEfficiency = 4
        saltEfficiency = 1
        category = FoodCategory.SPICE
    }

    val PEACH = config {
        overdueSpeed = 8
        overdueState = 145000
        fridgeEfficiency = 5
        category = FoodCategory.FRUIT
    }

    val PEACH_JAM = config {
        overdueSpeed = 7
        overdueState = 135000
        fridgeEfficiency = 2
        category = FoodCategory.HUMAN_MADE
    }

    val PEANUT = config {
        overdueSpeed = 5
        overdueState = 115000
        fridgeEfficiency = 1
        saltEfficiency = 3
        category = FoodCategory.NUT
    }

    val PEANUT_BUTTER_AND_JAM = config {
        overdueSpeed = 7
        overdueState = 90000
        fridgeEfficiency = 3
        category = FoodCategory.HUMAN_MADE
    }

    val PEAR = config {
        overdueSpeed = 9
        overdueState = 145000
        fridgeEfficiency = 5
        category = FoodCategory.FRUIT
    }

    val PECAN = config {
        overdueSpeed = 6
        overdueState = 50000
        fridgeEfficiency = 1
        saltEfficiency = 2
        category = FoodCategory.NUT
    }

    val PECAN_ICE_CREAM = config {
        overdueSpeed = 13
        overdueState = 90000
        fridgeEfficiency = 7
        category = FoodCategory.HUMAN_MADE
    }

    val PECAN_PIE = config {
        overdueSpeed = 18
        overdueState = 210000
        fridgeEfficiency = 9
        category = FoodCategory.HUMAN_MADE
    }

    val PEPPER = config {
        overdueSpeed = 2
        overdueState = 155000
        fridgeEfficiency = 0
        category = FoodCategory.SPICE
    }

    val PEPPERONI = config {
        overdueSpeed = 8
        overdueState = 225000
        fridgeEfficiency = 3
        saltEfficiency = 6
        category = FoodCategory.HUMAN_MADE
    }

    val PERSIMMON = config {
        overdueSpeed = 3
        overdueState = 115000
        fridgeEfficiency = 1
        category = FoodCategory.FRUIT
    }

    val PINEAPPLE = config {
        overdueSpeed = 8
        overdueState = 100000
        fridgeEfficiency = 5
        saltEfficiency = 1
        category = FoodCategory.FRUIT
    }
}