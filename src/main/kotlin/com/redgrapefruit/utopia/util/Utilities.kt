package com.redgrapefruit.utopia.util

import net.minecraft.item.FoodComponent

/**
 * Copies all the values from the given [FoodComponent] to given [FoodComponent.Builder] with decreases in values
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