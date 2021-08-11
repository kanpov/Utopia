package com.redgrapefruit.utopia.common.item

import com.mojang.datafixers.util.Pair
import com.redgrapefruit.utopia.common.GROUP
import com.redgrapefruit.utopia.common.RANDOM
import com.redgrapefruit.utopia.common.core.FoodCategory
import com.redgrapefruit.utopia.common.core.FoodConfig
import com.redgrapefruit.utopia.common.core.FoodState
import com.redgrapefruit.utopia.common.util.overrideComponentValues
import com.redgrapefruit.utopia.mixin.FoodComponentAccessor
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

/**
 * A rotten variant of a [FoodItem]
 */
class RottenFoodItem(name: String) : FoodItem(name) {
    init {
        state = FoodState.ROTTEN
        overrideEffects = true
    }

    override fun onComponentInit(access: FoodComponentAccessor, component: FoodComponent) {
        // Hunger (decreased)
        access.setHunger(config.category.baseHunger + config.hunger - 2)
        // Meat
        if (config.category == FoodCategory.MEAT) access.setMeat(true)
        // Snack
        if (config.category.baseHunger + config.hunger - 2 < 2) access.setSnack(true)
        // Saturation modifier (decreased)
        access.setSaturationModifier((config.category.baseSaturationModifier + config.saturationModifier) / 1.5f)
        // Effects
        access.setStatusEffects(component.statusEffects.apply {
            add(Pair.of(StatusEffectInstance(
                    StatusEffects.POISON,
                    RANDOM.nextInt(250) + 50,
                    RANDOM.nextInt(3) + 1
                ), 0.85f))
        })
    }
}