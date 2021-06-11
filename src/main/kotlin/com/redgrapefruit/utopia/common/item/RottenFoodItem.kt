package com.redgrapefruit.utopia.common.item

import com.redgrapefruit.utopia.common.GROUP
import com.redgrapefruit.utopia.common.RANDOM
import com.redgrapefruit.utopia.common.core.data.FoodCategory
import com.redgrapefruit.utopia.common.core.data.FoodConfig
import com.redgrapefruit.utopia.common.core.state.FoodState
import com.redgrapefruit.utopia.common.util.overrideComponentValues
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

/**
 * A rotten variant of a [FoodItem]
 */
class RottenFoodItem : FoodItem {
    constructor(config: FoodConfig) : super(config, GROUP, {
        val builder = FoodComponent.Builder()

        // Hunger (decreased)
        builder.hunger(config.category.baseHunger + config.hunger - 2)
        // Meat
        if (config.category == FoodCategory.MEAT) builder.meat()
        // Snack
        if (config.category.baseHunger + config.hunger - 2 < 2) builder.snack()
        // Saturation modifier (decreased)
        builder.saturationModifier((config.category.baseSaturationModifier + config.saturationModifier) / 1.5f)
        // Poison effect
        builder.statusEffect(StatusEffectInstance(
            StatusEffects.POISON,
            RANDOM.nextInt(250) + 50,
            RANDOM.nextInt(3) + 1
        ), 0.85f)

        builder.build()
    }) {
        state = FoodState.ROTTEN
        overrideEffects = true
    }

    constructor(config: FoodConfig, component: FoodComponent) : super(config, GROUP, {
        val builder = FoodComponent.Builder()

        // Overrides
        overrideComponentValues(component, builder, 2, 0.75f)
        // Poison effect
        builder.statusEffect(StatusEffectInstance(
            StatusEffects.POISON,
            RANDOM.nextInt(250) + 50,
            RANDOM.nextInt(3) + 1
        ), 0.85f)

        builder.build()
    }) {
        state = FoodState.ROTTEN
        overrideEffects = true
    }
}