package com.redgrapefruit.utopia.util

import com.redgrapefruit.utopia.item.OverdueFoodItem
import com.redgrapefruit.utopia.item.RancidDrinkItem
import com.redgrapefruit.utopia.item.RottenFoodItem
import net.minecraft.item.FoodComponent

interface ItemFoodMixinAccess {
    fun activateFood()
    fun named(name: String)
    fun setOverdueVariant(overdueVariant: OverdueFoodItem)
    fun setRottenVariant(rottenVariant: RottenFoodItem)
    fun isFoodActivated(): Boolean
}

interface ItemDrinkMixinAccess {
    fun activateDrink()
    fun setComponent(component: FoodComponent)
    fun setRancidSpeed(rancidSpeed: Int)
    fun setRancidState(rancidState: Int)
    fun setRancidVariant(rancidVariant: RancidDrinkItem)
    fun isDrinkActivated(): Boolean
}
