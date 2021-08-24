package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.GROUP
import com.redgrapefruit.utopia.core.DrinkProfile
import com.redgrapefruit.utopia.core.RealismEngine
import com.redgrapefruit.utopia.util.BlockingOverride
import net.dehydration.api.DrinkItem
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.FoodComponent
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.World

open class AdvancedDrinkItem(
    component: FoodComponent, var rancidSpeed: Int, var rancidState: Int)
    : DrinkItem(Settings().group(GROUP).maxCount(1).food(component)) {

    private lateinit var rancidVariant: RancidDrinkItem

    fun rancidVariant(variant: RancidDrinkItem): AdvancedDrinkItem {
        rancidVariant = variant
        return this
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        if (entity is PlayerEntity)
            RealismEngine.updateDrink(DrinkProfile[stack], rancidSpeed, rancidState, slot, world, entity, rancidVariant)
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        super.appendTooltip(stack, world, tooltip, context)

        RealismEngine.renderDrinkTooltip(tooltip, DrinkProfile[stack], rancidState)
    }
}

class RancidDrinkItem(internal val component: FoodComponent, rancidSpeed: Int, rancidState: Int) :
    AdvancedDrinkItem(component, rancidSpeed, rancidState) {

    @BlockingOverride
    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) = Unit

    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        RealismEngine.renderDrinkTooltip(tooltip, DrinkProfile[stack], rancidState, true)
    }
}
