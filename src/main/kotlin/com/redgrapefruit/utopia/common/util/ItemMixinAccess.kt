package com.redgrapefruit.utopia.common.util

import com.redgrapefruit.utopia.common.core.data.RFoodConfig
import com.redgrapefruit.utopia.common.core.state.RFoodProfile
import com.redgrapefruit.utopia.common.item.ROverdueFoodItem
import com.redgrapefruit.utopia.common.item.RRottenFoodItem

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