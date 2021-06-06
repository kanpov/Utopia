package com.redgrapefruit.utopia.util

import com.redgrapefruit.utopia.RANDOM
import com.redgrapefruit.utopia.Utopia
import com.redgrapefruit.utopia.module.Module
import com.redgrapefruit.utopia.module.SetModule

/**
 * A range of integers to randomly pick from
 */
@SetModule(Module.REALISM)
class IntRange(
    /**
     * Minimum value of the resulting int
     */
    private val min: Int,
    /**
     * Maximum value of the resulting int
     */
    private val max: Int
) {
    /**
     * Picks a random number from this range
     *
     * @return Random number
     */
    fun pick(): Int {
        val initial = max - min
        return RANDOM.nextInt(initial) + min
    }
}