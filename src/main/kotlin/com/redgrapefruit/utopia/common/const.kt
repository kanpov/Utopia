package com.redgrapefruit.utopia.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.FoodComponent
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.security.SecureRandom
import java.util.*

// Inline

const val ZERO_INT = 0
const val ZERO_FLOAT = 0.0f
const val UNUSED_PROPERTY: Int = Integer.MIN_VALUE
const val UNUSED_PROPERTY_FLOAT: Float = Float.MIN_VALUE
const val MOD_ID: String = "utopia"

// Instances

val LOG: Logger = LogManager.getLogger()
val GSON: Gson = GsonBuilder().setPrettyPrinting().create()
val RANDOM: Random = SecureRandom()
val GROUP: ItemGroup =
    FabricItemGroupBuilder.create(Identifier(MOD_ID, "utopia")).icon { ItemStack(Items.ACACIA_BOAT) }.build()

// Base FoodComponents

val EDIBLE_1: FoodComponent = createComponent(1, 0.4f)
val EDIBLE_3: FoodComponent = createComponent(3, 0.4f)
val EDIBLE_5: FoodComponent = createComponent(5, 0.5f)
val EDIBLE_7: FoodComponent = createComponent(7, 0.6f)
val EDIBLE_9: FoodComponent = createComponent(9, 0.6f)
val EDIBLE_10: FoodComponent = createComponent(10, 0.8f)
val EDIBLE_14: FoodComponent = createComponent(14, 1.0f)
val EDIBLE_18: FoodComponent = createComponent(18, 1.4f)

val BASE_COMPONENT_MAP: Map<String, FoodComponent> = mapOf(
    "edible_1" to EDIBLE_1, "edible_3" to EDIBLE_3, "edible_5" to EDIBLE_5,
    "edible_7" to EDIBLE_7, "edible_9" to EDIBLE_9, "edible_10" to EDIBLE_10,
    "edible_14" to EDIBLE_14, "edible_18" to EDIBLE_18
) // JSON value => FoodComponent map

private fun createComponent(hunger: Int, saturationModifier: Float)
    = FoodComponent.Builder().hunger(hunger).saturationModifier(saturationModifier).build()
