@file:JvmName("MiscUtil")

package com.redgrapefruit.utopia.util

import com.mojang.datafixers.util.Pair
import com.redgrapefruit.utopia.core.FoodConfig
import com.redgrapefruit.utopia.core.FoodProfile
import com.redgrapefruit.utopia.core.FridgeState
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import java.util.function.Predicate

// Color codes
const val BLACK = "§0"
const val DARK_BLUE = "§1"
const val DARK_GREEN = "§2"
const val DARK_AQUA = "§3"
const val DARK_RED = "§4"
const val DARK_PURPLE = "§5"
const val GOLD = "§6"
const val GRAY = "§7"
const val DARK_GRAY = "§8"
const val BLUE = "§9"
const val GREEN = "§a"
const val AQUA = "§b"
const val RED = "§c"
const val LIGHT_PURPLE = "§d"
const val YELLOW = "§e"
const val WHITE = "§f"

// Formatting codes
const val OBFUSCATED = "§k"
const val BOLD = "§l"
const val STRIKE_THROUGH = "§m"
const val UNDERLINE = "§n"
const val ITALIC = "§o"
const val RESET = "§r"
const val NEW_LINE = "\n"

fun breakLine(tooltip: MutableList<Text>) {
    tooltip += LiteralText("")
}


/**
 * Copies all the values from the given [FoodComponent] to given [FoodComponent.Builder] with decreases in values
 *
 * @param component Input [FoodComponent]
 * @param builder Output [FoodComponent.Builder]
 * @param hungerDecrease Decrease of hunger value
 * @param saturationModifierDecrease Decrease of saturation value
 */
fun overrideComponentValues(
    component: FoodComponent,
    builder: FoodComponent.Builder,
    hungerDecrease: Int,
    saturationModifierDecrease: Float
) {
    // Standard values
    builder.hunger(component.hunger - hungerDecrease)
    builder.saturationModifier(component.saturationModifier - saturationModifierDecrease)
    // Effects
    component.statusEffects.forEach { pair -> builder.statusEffect(pair.first, pair.second) }
    // Boolean values
    if (component.isMeat) builder.meat()
    if (component.isAlwaysEdible) builder.alwaysEdible()
    if (component.isSnack) builder.snack()
}

/**
 * Calculates current rot
 *
 * @param profile Food profile
 * @param config  Food config
 * @return Rot value
 */
fun calculateRot(profile: FoodProfile, config: FoodConfig): Int {
    var out: Int = config.rotSpeed
    if (config.category.canBePutInFridge && profile.fridgeState == FridgeState.NOT_COMPENSATED) {
        out -= config.fridgeEfficiency
        profile.fridgeState = FridgeState.NOT_IN_FRIDGE
    }
    return out
}

/**
 * Calculates current overdue
 *
 * @param profile Food profile
 * @param config  Food config
 * @return Overdue value
 */
fun calculateOverdue(profile: FoodProfile, config: FoodConfig): Int {
    var out: Int = config.overdueSpeed
    if (config.category.canBePutInFridge && profile.fridgeState == FridgeState.NOT_COMPENSATED) {
        out -= config.fridgeEfficiency
        profile.fridgeState = FridgeState.NOT_IN_FRIDGE
    }
    return out
}

/**
 * Accessible [FoodComponent] implementation
 */
data class MutableFoodComponent(
    var hunger: Int,
    var saturationModifier: Float,
    var meat: Boolean,
    var alwaysEdible: Boolean,
    var snack: Boolean,
    var statusEffects: List<Pair<StatusEffectInstance, Float>>
)

// Conversion extensions

/**
 * Converts a [MutableFoodComponent] to a [FoodComponent]
 */
fun MutableFoodComponent.asImmutable(): FoodComponent {
    val builder = FoodComponent.Builder()

    builder.hunger(hunger)
    builder.saturationModifier(saturationModifier)
    if (meat) builder.meat()
    if (alwaysEdible) builder.alwaysEdible()
    if (snack) builder.snack()
    statusEffects.forEach { pair -> builder.statusEffect(pair.first, pair.second) }

    return builder.build()
}

/**
 * Converts a [FoodComponent] to a [MutableFoodComponent]
 */
fun FoodComponent.asMutable(): MutableFoodComponent = MutableFoodComponent(
    hunger, saturationModifier, isMeat, isAlwaysEdible, isSnack, statusEffects
)

// <---- A simple ItemStack NBT system ---->

object ItemNBTManager {
    private val registry = mutableMapOf<Predicate<Item>, ItemNBT>()

    fun registerEntry(item: Predicate<Item>, itemNBT: ItemNBT) {
        registry[item] = itemNBT
    }

    fun searchEntry(item: Item): NBTSearchResult {
        registry.forEach { (key, value) ->
            if (key.test(item)) return NBTSearchResult(true, value)
        }
        return NBTSearchResult(false, null)
    }
}

data class ItemNBT(
    val serializer: (self: Item, nbt: NbtCompound) -> Unit,
    val deserializer: (self: Item, nbt: NbtCompound) -> Unit)

data class NBTSearchResult(val success: Boolean, val found: ItemNBT?)




/**
 * Marks an override intended to block the super class's logic
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class BlockingOverride
