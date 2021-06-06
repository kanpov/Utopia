package com.redgrapefruit.utopia.core

import com.redgrapefruit.utopia.util.RIntRange
import net.minecraft.entity.effect.StatusEffect

/**
 * This data class stores all the details about a food effect
 */
data class RFoodEffectConfig(
    /**
     * The applied [StatusEffect].
     */
    val statusEffect: StatusEffect,
    /**
     * The duration of the [StatusEffect].
     */
    val duration: Int = 0,
    /**
     * The [RIntRange] of possible durations.
     */
    val durationRange: RIntRange? = null,
    /**
     * The amplifier of the [StatusEffect].
     */
    val amplifier: Int = 0,
    /**
     * The [RIntRange] of possible durations.
     */
    val amplifierRange: RIntRange? = null,
    /**
     * Is the effect permanently applied. If true, sets [chance] to 1f.
     */
    val isPermanent: Boolean = false,
    /**
     * Is the effect always applied. If true, sets [duration] to [Int.MAX_VALUE].
     */
    val isAlwaysApplied: Boolean = false,
    /**
     * The chance of the effect being applied.
     */
    val chance: Float = 0f
)
