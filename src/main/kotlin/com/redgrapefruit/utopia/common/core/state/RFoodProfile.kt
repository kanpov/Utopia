package com.redgrapefruit.utopia.common.core.state

/**
 * Minimal loss of ticks to compensate.
 *
 * Used to avoid packet delays and random glitches
 */
internal const val MIN_TICK_LOSS: Long = 20L

/**
 * Contains changed-at-runtime values of a food type and serializes them (CCA).
 */
data class RFoodProfile(
    var rotProgress: Int = 0,
    var overdueProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false,
    var fridgeState: RFridgeState = RFridgeState.NOT_IN_FRIDGE
)