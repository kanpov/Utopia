package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.GROUP
import com.redgrapefruit.utopia.util.ItemNBT
import com.redgrapefruit.utopia.util.ItemNBTManager
import kotlinx.serialization.serializer
import net.dehydration.api.DrinkItem
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.nbt.NbtCompound

class AdvancedDrinkItem(
    component: FoodComponent, private val rancidSpeed: Int, private val rancidState: Int, val isRancid: Boolean = false)
    : DrinkItem(Settings().group(GROUP).maxCount(1).food(component)) {

    private var rancidProgress: Int = 0
    private var previousTick: Long = 0L
    private var isInitialized: Boolean = false
    private lateinit var rancidVariant: AdvancedDrinkItem

    fun rancidVariant(variant: AdvancedDrinkItem): AdvancedDrinkItem {
        rancidVariant = variant
        return this
    }

    companion object {
        init {
            ItemNBTManager.registerEntry({it is AdvancedDrinkItem}, ItemNBT(::serializer, ::deserializer))
        }

        private fun deserializer(self: Item, nbt: NbtCompound) {
            (self as AdvancedDrinkItem).apply {
                rancidProgress = nbt.getInt("Rancid Progress")
                previousTick = nbt.getLong("Previous Tick")
            }
        }

        private fun serializer(self: Item, nbt: NbtCompound) {
            (self as AdvancedDrinkItem).apply {
                nbt.putInt("Rancid Progress", rancidProgress)
                nbt.putLong("Previous Tick", previousTick)
            }
        }
    }
}
