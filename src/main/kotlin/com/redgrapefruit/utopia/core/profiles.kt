package com.redgrapefruit.utopia.core

import com.redgrapefruit.itemnbt.itemnbt.Classifier
import com.redgrapefruit.itemnbt.itemnbt.ItemData
import com.redgrapefruit.itemnbt.itemnbt.ItemDataManager
import com.redgrapefruit.utopia.item.AdvancedDrinkItem
import com.redgrapefruit.utopia.item.AdvancedFoodItem
import com.redgrapefruit.utopia.util.ItemDrinkMixinAccess
import com.redgrapefruit.utopia.util.ItemFoodMixinAccess
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import java.util.*

/**
 * Minimal loss of ticks to compensate.
 *
 * Used to avoid packet delays and random glitches
 */
const val MIN_TICK_LOSS: Long = 20L

/**
 * Contains changed-at-runtime values of food type
 */
data class FoodProfile(
    var rotProgress: Int = 0,
    var overdueProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false,
    var fridgeState: FridgeState = FridgeState.NOT_IN_FRIDGE
) : ItemData {
    override fun readNbt(item: Item, stack: ItemStack, nbt: NbtCompound) {
        rotProgress = nbt.getInt("Rot Progress")
        overdueProgress = nbt.getInt("Overdue Progress")
        previousTick = nbt.getLong("Previous Tick")
        isInitialized = nbt.getBoolean("Is Initialized")
        fridgeState = FridgeState.readNbt("Fridge State", nbt)
    }

    override fun writeNbt(item: Item, stack: ItemStack, nbt: NbtCompound) {
        nbt.putInt("Rot Progress", rotProgress)
        nbt.putInt("Overdue Progress", overdueProgress)
        nbt.putLong("Previous Tick", previousTick)
        nbt.putBoolean("Is Initialized", isInitialized)
        FridgeState.writeNbt("Fridge State", fridgeState, nbt)
    }

    companion object {
        private val classifier = Classifier { stack ->
            stack.item is AdvancedFoodItem || (stack.item as ItemFoodMixinAccess).isFoodActivated()
        }

        init {
            ItemDataManager.register(classifier, ::FoodProfile)
        }

        operator fun get(stack: ItemStack): FoodProfile {
            val raw = ItemDataManager.get(stack, classifier)
            Objects.requireNonNull(raw, "FoodProfile search failed")
            return raw as FoodProfile
        }
    }
}

/**
 * Contains changed-at-runtime values of drink type
 */
data class DrinkProfile(
    var rancidProgress: Int = 0,
    var previousTick: Long = 0L,
    var isInitialized: Boolean = false
) : ItemData {
    override fun readNbt(item: Item, stack: ItemStack, nbt: NbtCompound) {
        rancidProgress = nbt.getInt("Rancid Progress")
        previousTick = nbt.getLong("Previous Tick")
        isInitialized = nbt.getBoolean("Is Initialized")
    }

    override fun writeNbt(item: Item, stack: ItemStack, nbt: NbtCompound) {
        nbt.putInt("Rancid Progress", rancidProgress)
        nbt.putLong("Previous Tick", previousTick)
        nbt.putBoolean("Is Initialized", isInitialized)
    }

    companion object {
        private val classifier = Classifier { stack ->
            stack.item is AdvancedDrinkItem || (stack.item as ItemDrinkMixinAccess).isDrinkActivated()
        }

        init {
            ItemDataManager.register(classifier, ::DrinkProfile)
        }

        operator fun get(stack: ItemStack): DrinkProfile {
            val raw = ItemDataManager.get(stack, classifier)
            Objects.requireNonNull(raw, "DrinkProfile search failed")
            return raw as DrinkProfile
        }
    }
}
