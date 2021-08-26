package com.redgrapefruit.cryonic.core

/**
 * Minimal loss of ticks to compensate.
 *
 * Used to avoid packet delays and random glitches
 */
const val MIN_TICK_LOSS: Long = 20L

/**
 * Contains changed-at-runtime values of food type
 */
data class FoodProfile(
    var rotProgress: Int = 0,
    var overdueProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false,
    var fridgeState: FridgeState = FridgeState.NOT_IN_FRIDGE
)

/**
 * Contains changed-at-runtime values of drink type
 */
data class DrinkProfile(
    var rancidProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false
)
