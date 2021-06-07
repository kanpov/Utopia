package com.redgrapefruit.utopia.util

import com.redgrapefruit.utopia.core.data.RFoodConfig
import com.redgrapefruit.utopia.core.state.RFoodProfile
import com.redgrapefruit.utopia.item.ROverdueFoodItem
import com.redgrapefruit.utopia.item.RRottenFoodItem

/**
 * Duck interface for mixin interactions
 */
interface ItemMixinAccess {
    fun activate()
    fun setProfile(profile: RFoodProfile)
    fun setConfig(config: RFoodConfig)
    fun setOverdueVariant(overdueVariant: ROverdueFoodItem)
    fun setRottenVariant(rottenVariant: RRottenFoodItem)
    fun getProfile(): RFoodProfile?
    fun isActivated(): Boolean
}