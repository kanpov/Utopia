package com.redgrapefruit.utopia.common.item

import com.mojang.datafixers.util.Pair
import com.redgrapefruit.utopia.common.RANDOM
import com.redgrapefruit.utopia.common.core.FoodCategory
import com.redgrapefruit.utopia.common.core.FoodState
import com.redgrapefruit.utopia.common.util.MutableFoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent

/**
 * An overdue variant of a [FoodItem]
 */
class OverdueFoodItem(name: String) : FoodItem(name) {
    init {
        state = FoodState.OVERDUE
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
               StatusEffects.NAUSEA,
               RANDOM.nextInt(250) + 50,
               RANDOM.nextInt(3) + 1
            ), 0.9f))
            add(Pair.of(StatusEffectInstance(
                StatusEffects.BLINDNESS,
                RANDOM.nextInt(150) + 50,
                RANDOM.nextInt(2) + 1
            ), 0.7f))
            add(Pair.of(StatusEffectInstance(
                StatusEffects.SLOWNESS,
                RANDOM.nextInt(100) + 50,
                RANDOM.nextInt(2) + 1
            ), 0.45f))
        }
    }
}