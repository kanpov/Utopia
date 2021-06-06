package com.redgrapefruit.utopia.core

/**
 * Minimal loss of ticks to compensate.
 *
 * Used to avoid packet delays and random glitches
 */
const val MIN_TICK_LOSS: Int = 20

data class FoodProfile(
    val config: FoodConfig,
    var rotProgress: Int = 0,
    var overdueProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false,
    var fridgeState: FridgeState = FridgeState.NOT_IN_FRIDGE
)
