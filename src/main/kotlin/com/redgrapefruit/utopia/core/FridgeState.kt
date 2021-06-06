package com.redgrapefruit.utopia.core

/**
 * Current fridge state.
 */
enum class FridgeState(val boolValue: Boolean) {
    /**
     * Represents a state when the food is put inside of a fridge
     */
    IN_FRIDGE(true),

    /**
     * Represents a state when the food is taken out of a fridge, but the tick loss hasn't yet been compensated
     */
    NOT_COMPENSATED(false),

    /**
     * Represents a state when the food is taken out of a fridge and the tick loss has already been compensated
     */
    NOT_IN_FRIDGE(false)
}