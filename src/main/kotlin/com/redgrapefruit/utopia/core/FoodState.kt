package com.redgrapefruit.utopia.core

import com.redgrapefruit.utopia.module.Module
import com.redgrapefruit.utopia.module.SetModule

/**
 * A food state defines the tooltip rendering properties of a certain state
 */
@SetModule(Module.REALISM)
enum class FoodState(
    /**
     * Does this state display rot
     */
    val displayRot: Boolean,
    /**
     * Does this state display overdue
     */
    val displayOverdue: Boolean,
    /**
     * Does this state display properties about the fridge
     */
    val displayFridgeProperties: Boolean,
    /**
     * How this state is displayed in tooltips
     */
    val displayName: String
) {
    FRESH(true, true, true, "Fresh"),
    ROTTEN(false, false, false, "Rotten"),
    OVERDUE(false, false, false, "Overdue"),
    SALTED(true, true, false, "Salted")
}