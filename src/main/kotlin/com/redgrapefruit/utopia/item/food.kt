package com.redgrapefruit.utopia.item

import com.mojang.datafixers.util.Pair
import com.redgrapefruit.utopia.GROUP
import com.redgrapefruit.utopia.RANDOM
import com.redgrapefruit.utopia.core.*
import com.redgrapefruit.utopia.mixin.ItemAccessor
import com.redgrapefruit.utopia.util.*
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
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
open class AdvancedFoodItem : Item {
    // Linked data structures
    private var name: String = ""
    private var isComponentInitialized: Boolean = false
    protected val config: FoodConfig by reloaderDelegate { storedConfig(name) }

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
    }()))

    constructor(_name: String) : this(GROUP) {
        this.name = _name
        ComponentInitializeCallback.Event.register(ComponentInitializeCallback.listener { name, _ ->
            if (name == this.name) initComponent()
        })
    }

    // <---- EVENTS ---->

    fun rottenVariant(rottenVariant: RottenFoodItem): AdvancedFoodItem {
        this.rottenVariant = rottenVariant
        return this
    }

    fun overdueVariant(overdueVariant: OverdueFoodItem): AdvancedFoodItem {
        this.overdueVariant = overdueVariant
        return this
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        if (entity is PlayerEntity && !overrideEffects) {
            RealismEngine.updateFood(config, FoodProfile[stack], entity, slot, world, rottenVariant, overdueVariant, isSalt)
        }
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        super.appendTooltip(stack, world, tooltip, context)

        RealismEngine.renderFoodTooltip(tooltip, config, FoodProfile[stack], state)
    }

    // <---- COMPONENTS ---->

    private fun initComponent() {
        if (isComponentInitialized) return

        val currentConfig = config
        if (currentConfig == FoodConfig.Default)
            throw RuntimeException("Late-load system failed. Config not loaded at moment of execution")

        val mutable = foodComponent!!.asMutable()
        onComponentInit(mutable, foodComponent!!)

        val access = this as ItemAccessor
        access.setFoodComponent(mutable.asImmutable())

        isComponentInitialized = true
    }

    /**
     * Inheritable load to implement by subclasses
     */
    protected open fun onComponentInit(mutable: MutableFoodComponent, immutable: FoodComponent) {
        mutable.hunger = config.category.baseHunger + config.hunger
        if (config.category == FoodCategory.MEAT) mutable.meat = true
        if (config.category.baseHunger + config.hunger < 2) mutable.snack = true
        mutable.saturationModifier = config.category.baseSaturationModifier + config.saturationModifier
    }
}

/**
 * An overdue variant of a [AdvancedFoodItem]
 */
class OverdueFoodItem(name: String) : AdvancedFoodItem(name) {
    init {
        state = FoodState.OVERDUE
        overrideEffects = true
    }

    override fun onComponentInit(mutable: MutableFoodComponent, immutable: FoodComponent) {
        // Hunger (decreased)
        mutable.hunger = config.category.baseHunger + config.hunger - 2
        // Meat
        if (config.category == FoodCategory.MEAT) mutable.meat = true
        // Snack
        if (config.category.baseHunger + config.hunger - 2 < 2) mutable.snack = true
        // Saturation modifier (decreased)
        mutable.saturationModifier = (config.category.baseSaturationModifier + config.saturationModifier) / 1.5f
        // Effects
        mutable.statusEffects = immutable.statusEffects.apply {
            add(
                Pair.of(
                    StatusEffectInstance(
                StatusEffects.NAUSEA,
                RANDOM.nextInt(250) + 50,
                RANDOM.nextInt(3) + 1
            ), 0.9f))
            add(
                Pair.of(
                    StatusEffectInstance(
                StatusEffects.BLINDNESS,
                RANDOM.nextInt(150) + 50,
                RANDOM.nextInt(2) + 1
            ), 0.7f))
            add(
                Pair.of(
                    StatusEffectInstance(
                StatusEffects.SLOWNESS,
                RANDOM.nextInt(100) + 50,
                RANDOM.nextInt(2) + 1
            ), 0.45f))
        }
    }
}

/**
 * A rotten variant of a [AdvancedFoodItem]
 */
class RottenFoodItem(name: String) : AdvancedFoodItem(name) {
    init {
        state = FoodState.ROTTEN
        overrideEffects = true
    }

    override fun onComponentInit(mutable: MutableFoodComponent, immutable: FoodComponent) {
        // Hunger (decreased)
        mutable.hunger = config.category.baseHunger + config.hunger - 2
        // Meat
        if (config.category == FoodCategory.MEAT) mutable.meat = true
        // Snack
        if (config.category.baseHunger + config.hunger - 2 < 2) mutable.snack = true
        // Saturation modifier (decreased)
        mutable.saturationModifier = (config.category.baseSaturationModifier + config.saturationModifier) / 1.5f
        // Effects
        mutable.statusEffects = immutable.statusEffects.apply {
            add(Pair.of(StatusEffectInstance(
                StatusEffects.POISON,
                RANDOM.nextInt(250) + 50,
                RANDOM.nextInt(3) + 1
            ), 0.85f))
        }
    }
}

/**
 * A salted variant of a [AdvancedFoodItem]
 */
class SaltedFoodItem(name: String) : AdvancedFoodItem(name) {
    init {
        state = FoodState.SALTED
        isSalt = true
    }
}
