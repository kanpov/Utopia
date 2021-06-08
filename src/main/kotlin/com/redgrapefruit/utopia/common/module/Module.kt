package com.redgrapefruit.utopia.common.module

/**
 * A list of modules that this mod has
 */
enum class Module(internal val equivalent: String) {
    /**
     * Utopia.Realism makes food more realistic and hardcore
     */
    REALISM("realism"),

    /**
     * Utopia.Furniture adds furniture blocks that make storing food easier and more convenient
     */
    FURNITURE("furniture"),

    /**
     * Utopia.Exploration adds many new worldgen features to explore
     */
    EXPLORATION("exploration"),

    /**
     * Utopia.Building adds decorative building blocks to make a pretty kitchen
     */
    BUILDING("building"),

    /**
     * Utopia.Cooking extends Minecraft's cooking mechanics and adds new recipes and food
     */
    COOKING("cooking")
}