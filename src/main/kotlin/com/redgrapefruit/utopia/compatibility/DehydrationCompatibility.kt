package com.redgrapefruit.utopia.compatibility

import com.redgrapefruit.utopia.registry.DrinkRegistry
import net.dehydration.api.DehydrationAPI
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack

object DehydrationCompatibility : DehydrationAPI {
    override fun calculateDrinkThirst(stack: ItemStack, playerEntity: PlayerEntity): Int {
        return DrinkRegistry.getThirstFor(stack.item)
    }
}
