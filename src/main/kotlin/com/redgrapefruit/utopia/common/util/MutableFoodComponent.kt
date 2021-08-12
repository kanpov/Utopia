package com.redgrapefruit.utopia.common.util

import com.mojang.datafixers.util.Pair
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.FoodComponent

/**
 * Accessible [FoodComponent] implementation
 */
data class MutableFoodComponent(
    var hunger: Int,
    var saturationModifier: Float,
    var meat: Boolean,
    var alwaysEdible: Boolean,
    var snack: Boolean,
    var statusEffects: List<Pair<StatusEffectInstance, Float>>
)

// Conversion extensions

/**
 * Converts a [MutableFoodComponent] to a [FoodComponent]
 */
fun MutableFoodComponent.asImmutable(): FoodComponent {
    val builder = FoodComponent.Builder()

    builder.hunger(hunger)
    builder.saturationModifier(saturationModifier)
    if (meat) builder.meat()
    if (alwaysEdible) builder.alwaysEdible()
    if (snack) builder.snack()
    statusEffects.forEach { pair -> builder.statusEffect(pair.first, pair.second) }

    return builder.build()
}

/**
 * Converts a [FoodComponent] to a [MutableFoodComponent]
 */
fun FoodComponent.asMutable(): MutableFoodComponent = MutableFoodComponent(
    hunger, saturationModifier, isMeat, isAlwaysEdible, isSnack, statusEffects
)
