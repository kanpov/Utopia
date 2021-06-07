package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.GROUP
import com.redgrapefruit.utopia.core.RFoodCategory
import com.redgrapefruit.utopia.core.RFoodConfig
import com.redgrapefruit.utopia.core.RFoodState
import com.redgrapefruit.utopia.util.overrideComponentValues
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

/**
 * A rotten variant of a [RFoodItem]
 */
class RRottenFoodItem : RFoodItem {
    constructor(config: RFoodConfig) : super(config, GROUP, {
        val builder = FoodComponent.Builder()

        // Hunger (decreased)
        builder.hunger(config.category.baseHunger + config.hunger - 2)
        // Meat
        if (config.category == RFoodCategory.MEAT) builder.meat()
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
        state = RFoodState.ROTTEN
        overrideEffects = true
    }

    constructor(config: RFoodConfig, component: FoodComponent) : super(config, GROUP, {
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
        state = RFoodState.ROTTEN
        overrideEffects = true
    }
}