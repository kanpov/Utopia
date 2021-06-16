package com.redgrapefruit.utopia.common.core

import com.redgrapefruit.utopia.common.LOG
import net.minecraft.nbt.NbtCompound

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
    NOT_IN_FRIDGE(false);

    companion object Serialization {
        /**
         * Deserializes a [FridgeState] from an [NbtCompound]
         * @param prefix The prefix of the [FridgeState] to avoid conflicts
         * @param nbt The input [NbtCompound]
         * @return Deserialized value
         */
        fun fromTag(prefix: String, nbt: NbtCompound): FridgeState {
            // Check for invalid values
            val value = nbt.getInt("$prefix : Value")
            if (value > 2 || value < 0) LOG.error("Couldn't serialize FridgeState. Value is invalid")

            return when (value) {
                0 -> IN_FRIDGE
                1 -> NOT_COMPENSATED
                else -> NOT_IN_FRIDGE
            }
        }

        /**
         * Serializes a [FridgeState] into an [NbtCompound]
         * @param prefix The prefix of the [FridgeState] to avoid conflicts
         * @param state The serialized [FridgeState]
         * @param nbt The output [NbtCompound]
         */
        fun toTag(prefix: String, state: FridgeState, nbt: NbtCompound) {
            val value: Int = when (state) {
                IN_FRIDGE -> 0
                NOT_COMPENSATED -> 1
                else -> 2
            }

            nbt.putInt("$prefix : Value", value)
        }
    }
}