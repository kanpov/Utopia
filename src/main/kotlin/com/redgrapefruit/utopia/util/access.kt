package com.redgrapefruit.utopia.util

import com.redgrapefruit.utopia.core.DrinkProfile
import com.redgrapefruit.utopia.core.FoodProfile
import com.redgrapefruit.utopia.item.OverdueFoodItem
import com.redgrapefruit.utopia.item.RancidDrinkItem
import com.redgrapefruit.utopia.item.RottenFoodItem
import net.minecraft.item.FoodComponent

interface ItemFoodMixinAccess {
    fun activate()
    fun named(name: String)
    fun setOverdueVariant(overdueVariant: OverdueFoodItem)
    fun setRottenVariant(rottenVariant: RottenFoodItem)
    fun getProfile(): FoodProfile
    fun isActivated(): Boolean
}

interface ItemDrinkMixinAccess {
    fun activate()
    fun setComponent(component: FoodComponent)
    fun setRancidSpeed(rancidSpeed: Int)
    fun setRancidState(rancidState: Int)
    fun setRancidVariant(rancidVariant: RancidDrinkItem)
    fun isActivated(): Boolean
    fun getProfile(): DrinkProfile
}
