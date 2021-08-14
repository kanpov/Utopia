package com.redgrapefruit.utopia.item

import com.mojang.datafixers.util.Pair
import com.redgrapefruit.utopia.RANDOM
import com.redgrapefruit.utopia.core.FoodCategory
import com.redgrapefruit.utopia.core.FoodState
import com.redgrapefruit.utopia.util.MutableFoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

/**
 * A rotten variant of a [AdvancedFoodItem]
 */
class RottenFoodItem(name: String) : AdvancedFoodItem(name) {
    init {
        state = FoodState.ROTTEN
        overrideEffects = true
    }

    override fun onComponentInit(mutable: MutableFoodComponent, immutable: FoodComponent) {
        // Hunger (decreased)
        mutable.hunger = config.category.baseHunger + config.hunger - 2
        // Meat
        if (config.category == FoodCategory.MEAT) mutable.meat = true
        // Snack
        if (config.category.baseHunger + config.hunger - 2 < 2) mutable.snack = true
        // Saturation modifier (decreased)
        mutable.saturationModifier = (config.category.baseSaturationModifier + config.saturationModifier) / 1.5f
        // Effects
        mutable.statusEffects = immutable.statusEffects.apply {
            add(Pair.of(StatusEffectInstance(
                    StatusEffects.POISON,
                    RANDOM.nextInt(250) + 50,
                    RANDOM.nextInt(3) + 1
                ), 0.85f))
        }
    }
}