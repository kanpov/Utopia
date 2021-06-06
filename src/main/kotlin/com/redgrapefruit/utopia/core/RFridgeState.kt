package com.redgrapefruit.utopia.core

import com.redgrapefruit.utopia.LOG
import net.minecraft.nbt.CompoundTag

/**
 * Current fridge state.
 */
enum class RFridgeState(val boolValue: Boolean) {
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
    NOT_IN_FRIDGE(false);

    companion object {
        /**
         * Deserializes a [RFridgeState] from a [CompoundTag]
         * @param prefix The prefix of the [RFridgeState] to avoid conflicts
         * @param tag The input [CompoundTag]
         * @return Deserialized value
         */
        internal fun fromTag(prefix: String, tag: CompoundTag): RFridgeState {
            // Check for invalid values
            val value = tag.getInt("$prefix : Value")
            if (value > 2 || value < 0) LOG.error("Couldn't serialize FridgeState. Value is invalid")

            return when (value) {
                0 -> IN_FRIDGE
                1 -> NOT_COMPENSATED
                else -> NOT_IN_FRIDGE
            }
        }

        /**
         * Serializes a [RFridgeState] into a [CompoundTag]
         * @param prefix The prefix of the [RFridgeState] to avoid conflicts
         * @param state The serialized [RFridgeState]
         * @param tag The output [CompoundTag]
         */
        internal fun toTag(prefix: String, state: RFridgeState, tag: CompoundTag) {
            val value: Int = when (state) {
                IN_FRIDGE -> 0
                NOT_COMPENSATED -> 1
                else -> 2
            }

            tag.putInt("$prefix : Value", value)
        }
    }
}