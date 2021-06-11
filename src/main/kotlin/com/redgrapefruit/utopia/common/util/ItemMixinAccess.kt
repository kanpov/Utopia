package com.redgrapefruit.utopia.common.util

import com.redgrapefruit.utopia.common.core.data.FoodConfig
import com.redgrapefruit.utopia.common.core.state.FoodProfile
import com.redgrapefruit.utopia.common.item.OverdueFoodItem
import com.redgrapefruit.utopia.common.item.RottenFoodItem

/**
 * Duck interface for mixin interactions
 */
interface ItemMixinAccess {
    fun activate()
    fun setProfile(profile: FoodProfile)
    fun setConfig(config: FoodConfig)
    fun setOverdueVariant(overdueVariant: OverdueFoodItem)
    fun setRottenVariant(rottenVariant: RottenFoodItem)
    fun getProfile(): FoodProfile?
    fun isActivated(): Boolean
}