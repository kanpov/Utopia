package com.redgrapefruit.cryonic.util

import com.redgrapefruit.cryonic.core.DrinkProfile
import com.redgrapefruit.cryonic.core.FoodProfile
import com.redgrapefruit.cryonic.item.OverdueFoodItem
import com.redgrapefruit.cryonic.item.RancidDrinkItem
import com.redgrapefruit.cryonic.item.RottenFoodItem
import net.minecraft.item.FoodComponent

interface ItemFoodMixinAccess {
    fun activateFood()
    fun named(name: String)
    fun setOverdueVariant(overdueVariant: OverdueFoodItem)
    fun setRottenVariant(rottenVariant: RottenFoodItem)
    fun getProfile(): FoodProfile
    fun isFoodActivated(): Boolean
}

interface ItemDrinkMixinAccess {
    fun activateDrink()
    fun setComponent(component: FoodComponent)
    fun setRancidSpeed(rancidSpeed: Int)
    fun setRancidState(rancidState: Int)
    fun setRancidVariant(rancidVariant: RancidDrinkItem)
    fun isDrinkActivated(): Boolean
    fun getProfile(): DrinkProfile
}
