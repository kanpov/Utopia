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
class RProfileComponent(
    var rotProgress: Int = 0,
    var overdueProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false,
    var fridgeState: RFridgeState = RFridgeState.NOT_IN_FRIDGE
) : Component {
    override fun readFromNbt(tag: CompoundTag) {
        rotProgress = tag.getInt("Rot Progress")
        overdueProgress = tag.getInt("Overdue Progress")
        previousTick = tag.getLong("Previous Tick")
        isInitialized = tag.getBoolean("Is Initialized")
        fridgeState = RFridgeState.fromTag("Fridge State", tag)
    }

    override fun writeToNbt(tag: CompoundTag) {
        tag.putInt("Rot Progress", rotProgress)
        tag.putInt("Overdue Progress", overdueProgress)
        tag.putLong("Previous Tick", previousTick)
        tag.putBoolean("Is Initialized", isInitialized)
        RFridgeState.toTag("Fridge State", fridgeState, tag)
    }
}
