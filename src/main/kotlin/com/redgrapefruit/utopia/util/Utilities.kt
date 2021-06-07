package com.redgrapefruit.utopia.util

import com.redgrapefruit.utopia.core.RFoodConfig
import com.redgrapefruit.utopia.core.RFoodProfile
import com.redgrapefruit.utopia.core.RFridgeState
import net.minecraft.item.FoodComponent

/**
 * Copies all the values from the given [FoodComponent] to given [FoodComponent.Builder] with decreases in values
 *
 * @param component Input [FoodComponent]
 * @param builder Output [FoodComponent.Builder]
 * @param hungerDecrease Decrease of hunger value
 * @param saturationModifierDecrease Decrease of saturation value
 */
fun overrideComponentValues(component: FoodComponent, builder: FoodComponent.Builder, hungerDecrease: Int, saturationModifierDecrease: Float) {
    // Standard values
    builder.hunger(component.hunger - hungerDecrease)
    builder.saturationModifier(component.saturationModifier - saturationModifierDecrease)
    // Effects
    component.statusEffects.forEach { pair -> builder.statusEffect(pair.first, pair.second) }
    // Boolean values
    if (component.isMeat) builder.meat()
    if (component.isAlwaysEdible) builder.alwaysEdible()
    if (component.isSnack) builder.snack()
}

/**
 * Calculates current rot
 *
 * @param profile Food profile
 * @param config  Food config
 * @return Rot value
 */
fun calculateRot(profile: RFoodProfile, config: RFoodConfig): Int {
    var out: Int = config.rotSpeed
    if (config.category.canBePutInFridge && profile.fridgeState == RFridgeState.NOT_COMPENSATED) {
        out -= config.fridgeEfficiency
        profile.fridgeState = RFridgeState.NOT_IN_FRIDGE
    }
    return out
}

/**
 * Calculates current overdue
 *
 * @param profile Food profile
 * @param config  Food config
 * @return Overdue value
 */
fun calculateOverdue(profile: RFoodProfile, config: RFoodConfig): Int {
    var out: Int = config.overdueSpeed
    if (config.category.canBePutInFridge && profile.fridgeState == RFridgeState.NOT_COMPENSATED) {
        out -= config.fridgeEfficiency
        profile.fridgeState = RFridgeState.NOT_IN_FRIDGE
    }
    return out
}
