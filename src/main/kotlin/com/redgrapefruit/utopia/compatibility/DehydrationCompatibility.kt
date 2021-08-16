package com.redgrapefruit.utopia.compatibility

import com.redgrapefruit.utopia.item.RancidDrinkItem
import com.redgrapefruit.utopia.registry.DrinkRegistry
import net.dehydration.api.DehydrationAPI
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import kotlin.random.Random

object DehydrationCompatibility : DehydrationAPI {
    override fun onDrink(stack: ItemStack, playerEntity: PlayerEntity) {
        super.onDrink(stack, playerEntity)

        // Poison the player when drinking rancid stuff
        if (stack.item is RancidDrinkItem) {
            playerEntity.addStatusEffect(
                StatusEffectInstance(
                    StatusEffects.POISON,
                    Random.nextInt(150, 301),
                    Random.nextInt(0, 3)
                )
            )
        }
    }

    override fun calculateDrinkThirst(stack: ItemStack, playerEntity: PlayerEntity): Int {
        return DrinkRegistry.getThirstFor(stack.item)
    }
}
