package com.redgrapefruit.utopia.core

/**
 * A food category classifies an entire group of food
 */
enum class RFoodCategory(
    /**
     * The name displayed inside the tooltips
     */
    val displayName: String,
    /**
     * Can the food from this category rot
     */
    val canRot: Boolean,
    /**
     * Can the food from this category overdue
     */
    val canOverdue: Boolean,
    /**
     * Can the food from this category be put inside of a fridge
     */
    val canBePutInFridge: Boolean,
    /**
     * The detailed description about the category inside the tooltips
     */
    val details: String
) {
    MEAT("Meat", true, false, true, "Trusty old meat."),
    FRUIT("Fruit", false, true, true, "Sweet, juicy fruit."),
    VEGETABLE("Berries", false, true, true, "Extremely healthy vegetable."),
    BERRIES("Berries", false, true, false, "Small and tasty berries."),
    FISH("Fish", false, true, true, "Nice and yummy fish."),
    PRODUCT("Product", false, true, true, "Cooked product - bakery, soup, stew etc."),
    MISCELLANEOUS("Miscellaneous", false, true, false, "Food that doesn't fit in regular categories")
}