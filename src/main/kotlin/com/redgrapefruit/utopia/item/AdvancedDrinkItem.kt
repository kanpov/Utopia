package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.GROUP
import com.redgrapefruit.utopia.ZERO_INT
import com.redgrapefruit.utopia.core.RealismEngine
import com.redgrapefruit.utopia.util.ItemNBT
import com.redgrapefruit.utopia.util.ItemNBTManager
import net.dehydration.api.DrinkItem
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Text
import net.minecraft.world.World

open class AdvancedDrinkItem(
    component: FoodComponent, internal val rancidSpeed: Int, internal val rancidState: Int)
    : DrinkItem(Settings().group(GROUP).maxCount(1).food(component)) {

    internal var rancidProgress: Int = 0
    internal var previousTick: Long = 0L
    internal var isInitialized: Boolean = false
    private lateinit var rancidVariant: RancidDrinkItem

    fun rancidVariant(variant: RancidDrinkItem): AdvancedDrinkItem {
        rancidVariant = variant
        return this
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        if (entity is PlayerEntity) RealismEngine.updateDrink(this, slot, world, entity, rancidVariant)
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        super.appendTooltip(stack, world, tooltip, context)

        RealismEngine.renderDrinkTooltip(tooltip, this)
    }

    companion object {
        init {
            ItemNBTManager.registerEntry({it is AdvancedDrinkItem}, ItemNBT(::serializer, ::deserializer))
        }

        private fun deserializer(self: Item, nbt: NbtCompound) {
            (self as AdvancedDrinkItem).apply {
                rancidProgress = nbt.getInt("Rancid Progress")
                previousTick = nbt.getLong("Previous Tick")
                isInitialized = nbt.getBoolean("Is Initialized")
            }
        }

        private fun serializer(self: Item, nbt: NbtCompound) {
            (self as AdvancedDrinkItem).apply {
                nbt.putInt("Rancid Progress", rancidProgress)
                nbt.putLong("Previous Tick", previousTick)
                nbt.putBoolean("Is Initialized", isInitialized)
            }
        }
    }
}

class RancidDrinkItem(component: FoodComponent) : AdvancedDrinkItem(component, ZERO_INT, ZERO_INT) {

}
