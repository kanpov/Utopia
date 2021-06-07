package com.redgrapefruit.utopia.item

import com.redgrapefruit.utopia.GROUP
import com.redgrapefruit.utopia.core.*
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
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
open class RFoodItem : Item {
    // Linked data structures
    private val config: RFoodConfig
    val profile: RFoodProfile
    // Variant settings
    protected var state: RFoodState = RFoodState.FRESH
    protected var overrideEffects: Boolean = false
    protected var isSalt: Boolean = false
    // Linked variants
    var rottenVariant: RRottenFoodItem? = null
    var overdueVariant: ROverdueFoodItem? = null

    /**
     * Protected constructor for creating customized [FoodComponent] instances
     * @param config [RFoodConfig] of this food item
     * @param group The [ItemGroup] that the item belongs to
     * @param componentAction A lambda that returns the generated [FoodComponent]
     */
    protected constructor(
        config: RFoodConfig,
        group: ItemGroup,
        componentAction: () -> FoodComponent
    ) : super(Settings().group(group).food(componentAction.invoke())) {
        this.config = config
        this.profile = RFoodProfile()
    }

    /**
     * Public constructor for creating standard instances of food items (fresh)
     * @param config [RFoodConfig] of this food item
     */
    constructor(config: RFoodConfig) : this(config, GROUP, {
        val builder = FoodComponent.Builder()

        // Hunger
        builder.hunger(config.category.baseHunger + config.hunger)
        // Meat
        if (config.category == RFoodCategory.MEAT) builder.meat()
        // Snack
        if (config.category.baseHunger + config.hunger < 2) builder.snack()
        // Saturation modifier
        builder.saturationModifier(config.category.baseSaturationModifier + config.saturationModifier)
        // Effects
        config.effects.forEach { effectConfig ->
            // If durationRange isn't defined (null), then check if the effect is permanent, if yes, the duration is 999999, else it's effectConfig.duration
            // Else pick a random duration out of the durationRange using IntRange.pick
            val duration = if (effectConfig.durationRange == null)
                (if (effectConfig.isPermanent) 999999 else effectConfig.duration)
            else effectConfig.durationRange.pick()

            // If amplifierRange isn't defined (null), then use effectConfig.amplifier
            // Else pick a random amplifier out of the amplifierRange using IntRange.pick
            val amplifier = if (effectConfig.amplifierRange == null)
                effectConfig.amplifier
            else effectConfig.amplifierRange.pick()

            builder.statusEffect(
                StatusEffectInstance(
                    effectConfig.statusEffect,
                    duration,
                    amplifier
                ), if (effectConfig.isAlwaysApplied) 1f else effectConfig.chance
            )
        }

        builder.build()
    })

    // Builders

    fun rottenVariant(rottenVariant: RRottenFoodItem) : RFoodItem {
        this.rottenVariant = rottenVariant
        return this
    }

    fun overdueVariant(overdueVariant: ROverdueFoodItem) : RFoodItem {
        this.overdueVariant = overdueVariant
        return this
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        if (entity is PlayerEntity) {
            RFoodEngine.inventoryTick(config, profile, entity, slot, world, rottenVariant, overdueVariant, isSalt)
        }
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        super.appendTooltip(stack, world, tooltip, context)

        RFoodEngine.appendTooltip(tooltip, config, profile, state)
    }
}