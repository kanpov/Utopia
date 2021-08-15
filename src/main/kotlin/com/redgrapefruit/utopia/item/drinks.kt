package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.GROUP
import com.redgrapefruit.utopia.ZERO_INT
import com.redgrapefruit.utopia.core.DrinkProfile
import com.redgrapefruit.utopia.core.RealismEngine
import com.redgrapefruit.utopia.util.BlockingOverride
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
    component: FoodComponent, var rancidSpeed: Int, var rancidState: Int)
    : DrinkItem(Settings().group(GROUP).maxCount(1).food(component)) {

    protected val profile: DrinkProfile = DrinkProfile()
    private lateinit var rancidVariant: RancidDrinkItem

    fun rancidVariant(variant: RancidDrinkItem): AdvancedDrinkItem {
        rancidVariant = variant
        return this
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        if (entity is PlayerEntity)
            RealismEngine.updateDrink(profile, rancidSpeed, rancidState, slot, world, entity, rancidVariant)
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        super.appendTooltip(stack, world, tooltip, context)

        RealismEngine.renderDrinkTooltip(tooltip, profile, rancidState)
    }

    companion object {
        init {
            ItemNBTManager.registerEntry({it is AdvancedDrinkItem}, ItemNBT(::serializer, ::deserializer))
        }

        private fun deserializer(self: Item, nbt: NbtCompound) {
            (self as AdvancedDrinkItem).apply {
                profile.rancidProgress = nbt.getInt("Rancid Progress")
                profile.previousTick = nbt.getLong("Previous Tick")
                profile.isInitialized = nbt.getBoolean("Is Initialized")
            }
        }

        private fun serializer(self: Item, nbt: NbtCompound) {
            (self as AdvancedDrinkItem).apply {
                nbt.putInt("Rancid Progress", profile.rancidProgress)
                nbt.putLong("Previous Tick", profile.previousTick)
                nbt.putBoolean("Is Initialized", profile.isInitialized)
            }
        }
    }
}

class RancidDrinkItem(internal val component: FoodComponent, rancidSpeed: Int, rancidState: Int) :
    AdvancedDrinkItem(component, rancidSpeed, rancidState) {

    @BlockingOverride
    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) = Unit

    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        RealismEngine.renderDrinkTooltip(tooltip, profile, rancidState, true)
    }
}
