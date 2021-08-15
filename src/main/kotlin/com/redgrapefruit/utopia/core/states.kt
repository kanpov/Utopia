package com.redgrapefruit.utopia.core

import net.minecraft.nbt.NbtCompound
import java.lang.ArithmeticException

/**
 * A food state defines the tooltip rendering properties of a certain state
 */
enum class FoodState(
    /**
     * Does this state display rot
     */
    val displayRot: Boolean,
    /**
     * Does this state display overdue
     */
    val displayOverdue: Boolean,
    /**
     * Does this state display properties about the fridge
     */
    val displayFridgeProperties: Boolean,
    /**
     * How this state is displayed in tooltips
     */
    val displayName: String
) {
    FRESH(true, true, true, "Fresh"),
    ROTTEN(false, false, false, "Rotten"),
    OVERDUE(false, false, false, "Overdue"),
    SALTED(true, true, false, "Salted")
}

/**
 * Current fridge state.
 */
enum class FridgeState(val boolValue: Boolean, val nbtKey: Int) {
    /**
     * Represents a state when the food is put inside of a fridge
     */
    IN_FRIDGE(true, 0),

    /**
     * Represents a state when the food is taken out of a fridge, but the tick loss hasn't yet been compensated
     */
    NOT_COMPENSATED(false, 1),

    /**
     * Represents a state when the food is taken out of a fridge and the tick loss has already been compensated
     */
    NOT_IN_FRIDGE(false, 2);

    companion object Serialization {
        private fun byNbtKey(nbtKey: Int): FridgeState {
            return when (nbtKey) {
                0 -> IN_FRIDGE
                1 -> NOT_COMPENSATED
                2 -> NOT_IN_FRIDGE
                else -> throw ArithmeticException("NBT Key for FridgeState is invalid")
            }
        }

        /**
         * Deserializes a [FridgeState] from an [NbtCompound]
         * @param prefix The prefix of the [FridgeState] to avoid conflicts
         * @param nbt The input [NbtCompound]
         * @return Deserialized value
         */
        fun readNbt(prefix: String, nbt: NbtCompound): FridgeState {
            return byNbtKey(nbt.getInt("$prefix : Value"))
        }

        /**
         * Serializes a [FridgeState] into an [NbtCompound]
         * @param prefix The prefix of the [FridgeState] to avoid conflicts
         * @param state The serialized [FridgeState]
         * @param nbt The output [NbtCompound]
         */
        fun writeNbt(prefix: String, state: FridgeState, nbt: NbtCompound) {
            nbt.putInt("$prefix : Value", state.nbtKey)
        }
    }
}

/**
 * A food category classifies an entire group of food
 */
enum class FoodCategory(
    /**
     * The base hunger value of this category. Only used in new food
     */
    val baseHunger: Int,
    /**
     * The base saturation modifier of this category. Only used in new food
     */
    val baseSaturationModifier: Float,
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
    MEAT(4, 1.6f, "Meat", true, false, true, "Trusty old meat."),
    FRUIT(2, 1.2f, "Fruit", false, true, true, "Sweet, juicy fruit."),
    VEGETABLE(2, 1.3f, "Berries", false, true, true, "Extremely healthy vegetable."),
    BERRIES(1, 0.6f, "Berries", false, true, false, "Small and tasty berries."),
    FISH(3, 1.25f, "Fish", false, true, true, "Nice and yummy fish."),
    NUT(2, 1.1f, "Nut", false, true, false, "Crunchy nuts."),
    PLANT(1, 0.8f, "Plant", false, true, false, "An edible plant."),
    HUMAN_MADE(3, 1f, "Human Made", false, true, true, "Cooked product - bakery, soup, stew etc."),
    DAIRY(2, 1.2f, "Dairy", false, true, true, "Dairy products."),
    SPICE(1, 0.65f, "Spice", false, true, false, "Upgrade!"),
    MISCELLANEOUS(2, 0.75f, "Miscellaneous", false, true, false, "Food that doesn't fit in regular categories");

    companion object {
        /**
         * Reads a [FoodCategory] from a raw [String] declared in a config JSON, else throws a [RuntimeException]
         */
        fun fromString(raw: String): FoodCategory {
            values().forEach { value ->
                val expected = value.name.lowercase()
                if (raw == expected) return value
            }

            throw RuntimeException("Could not parse FoodCategory; a crash may occur")
        }
    }
}
