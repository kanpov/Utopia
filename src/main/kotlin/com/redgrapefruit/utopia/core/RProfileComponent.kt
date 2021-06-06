package com.redgrapefruit.utopia.core

import dev.onyxstudios.cca.api.v3.component.Component
import net.minecraft.nbt.CompoundTag

/**
 * Minimal loss of ticks to compensate.
 *
 * Used to avoid packet delays and random glitches
 */
const val MIN_TICK_LOSS: Int = 20

/**
 * Contains changed-at-runtime values of a food type and serializes them (CCA).
 */
data class RProfileComponent(
    var rotProgress: Int = 0,
    var overdueProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false,
    var fridgeState: RFridgeState = RFridgeState.NOT_IN_FRIDGE
)
