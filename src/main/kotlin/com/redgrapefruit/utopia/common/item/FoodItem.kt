package com.redgrapefruit.utopia.common.item

import com.redgrapefruit.utopia.common.GROUP
import com.redgrapefruit.utopia.common.core.*
import com.redgrapefruit.utopia.mixin.FoodComponentAccessor
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.World

/**
 * Represents a fresh food item as well as a base for other variants
 */
@Suppress("JoinDeclarationAndAssignment")
open class FoodItem : Item {
    // Linked data structures
    private var name: String = ""
    private var isComponentInitialized: Boolean = false
    protected val config: FoodConfig by reloaderDelegate { storedConfig(name) }
    val profile: FoodProfile

    // Variant settings
    protected var state: FoodState = FoodState.FRESH
    protected var overrideEffects: Boolean = false
    protected var isSalt: Boolean = false

    // Linked variants
    var rottenVariant: RottenFoodItem? = null
    var overdueVariant: OverdueFoodItem? = null

    @Suppress("RedundantLambdaOrAnonymousFunction")
    private constructor(
        group: ItemGroup,
    ) : super(Settings().group(group).food({
        val builder = FoodComponent.Builder()
        builder.build()
    }())) {
        this.profile = FoodProfile()
    }

    constructor(name: String) : this(GROUP) { this.name = name }

    // Builders

    fun rottenVariant(rottenVariant: RottenFoodItem): FoodItem {
        this.rottenVariant = rottenVariant
        return this
    }

    fun overdueVariant(overdueVariant: OverdueFoodItem): FoodItem {
        this.overdueVariant = overdueVariant
        return this
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        if (entity is PlayerEntity && !overrideEffects) {
            FoodEngine.inventoryTick(config, profile, entity, slot, world, rottenVariant, overdueVariant, isSalt)
        }
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        super.appendTooltip(stack, world, tooltip, context)

        FoodEngine.appendTooltip(tooltip, config, profile, state)
    }

    /**
     * Hacky solution to late-load [FoodComponent]s
     */
    private fun initComponent() {
        if (isComponentInitialized) return

        val access = foodComponent as? FoodComponentAccessor
            ?: throw RuntimeException("Mixin critical failure. Cannot cast to FoodComponentAccessor")

        val currentConfig = config
        if (currentConfig == FoodConfig.DEFAULT)
            throw RuntimeException("Late-load system failed. Config not loaded at moment of execution")

        onComponentInit(access, foodComponent!!)
    }

    /**
     * Inheritable load to implement by subclasses
     */
    protected open fun onComponentInit(access: FoodComponentAccessor, component: FoodComponent) {
        access.setHunger(config.category.baseHunger + config.hunger)
        if (config.category == FoodCategory.MEAT) access.setMeat(true)
        if (config.category.baseHunger + config.hunger < 2) access.setSnack(true)
        access.setSaturationModifier(config.category.baseSaturationModifier + config.saturationModifier)
    }
}