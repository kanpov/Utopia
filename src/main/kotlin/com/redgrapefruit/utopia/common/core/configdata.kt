package com.redgrapefruit.utopia.common.core

import com.redgrapefruit.utopia.common.MOD_ID
import com.redgrapefruit.utopia.common.UNUSED_PROPERTY
import com.redgrapefruit.utopia.common.UNUSED_PROPERTY_FLOAT
import kotlinx.serialization.json.*
import net.fabricmc.fabric.api.resource.ResourceManagerHelper
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener
import net.minecraft.resource.ResourceManager
import net.minecraft.resource.ResourceType
import net.minecraft.util.Identifier
import java.io.InputStream

// <----  Managing data-driven FoodConfigs  ---->

/**
 * (Re)loads [FoodConfig]s
 */
object FoodConfigReloader : SimpleSynchronousResourceReloadListener {
    fun register() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(FoodConfigReloader)
    }

    override fun reload(manager: ResourceManager) {
        // Clear FoodConfigStorage to reload everything
        FoodConfigStorage.clear()

        manager.findResources("config") { path -> path.endsWith(".config.json") }.forEach { id ->
            process(manager.getResource(id).inputStream, id)
        }
    }

    private fun process(input: InputStream, id: Identifier) {
        // Read JsonObject
        val jsonObject: JsonObject
        input.use { stream ->
            jsonObject = Json.decodeFromString(JsonObject.serializer(), stream.readBytes().decodeToString())
        }

        // Parse everything

        // FoodCategory. This also determines which properties are required afterwards
        val category = FoodCategory.fromString(
            assertConfigProperty(jsonObject["category"], "category").jsonPrimitive.content)
        // Rot values
        var rotSpeed = UNUSED_PROPERTY
        var rotState = UNUSED_PROPERTY
        if (category.canRot) {
            rotSpeed = assertConfigProperty(jsonObject["rotSpeed"], "rotSpeed").jsonPrimitive.int
            rotState = assertConfigProperty(jsonObject["rotState"], "rotState").jsonPrimitive.int
        }
        // Overdue values
        var overdueSpeed = UNUSED_PROPERTY
        var overdueState = UNUSED_PROPERTY
        if (category.canOverdue) {
            overdueSpeed = assertConfigProperty(jsonObject["overdueSpeed"], "overdueSpeed").jsonPrimitive.int
            overdueState = assertConfigProperty(jsonObject["overdueState"], "overdueState").jsonPrimitive.int
        }
        // Fridge
        var fridgeEfficiency = UNUSED_PROPERTY
        if (category.canBePutInFridge) {
            fridgeEfficiency = assertConfigProperty(jsonObject["fridgeEfficiency"], "fridgeEfficiency").jsonPrimitive.int
        }
        // Salt
        val saltEfficiency =
            if (jsonObject.contains("saltEfficiency")) jsonObject["saltEfficiency"]!!.jsonPrimitive.int else UNUSED_PROPERTY
        // Hunger & Saturation
        val hunger = assertConfigProperty(jsonObject["hunger"], "hunger").jsonPrimitive.int
        val saturationModifier = assertConfigProperty(jsonObject["saturationModifier"], "saturationModifier").jsonPrimitive.float

        // Construct config using the DSL
        val config = config {
            this.category = category
            if (rotSpeed != UNUSED_PROPERTY) this.rotSpeed = rotSpeed
            if (rotState != UNUSED_PROPERTY) this.rotState = rotState
            if (overdueSpeed != UNUSED_PROPERTY) this.overdueSpeed = overdueSpeed
            if (overdueState != UNUSED_PROPERTY) this.overdueState = overdueState
            if (fridgeEfficiency != UNUSED_PROPERTY) this.fridgeEfficiency = fridgeEfficiency
            if (saltEfficiency != UNUSED_PROPERTY) this.saltEfficiency = saltEfficiency
            if (hunger != UNUSED_PROPERTY) this.hunger = hunger
            if (saturationModifier != UNUSED_PROPERTY_FLOAT) this.saturationModifier = saturationModifier
        }

        // Put the config in the storage
        val name = id.toString().remove("$MOD_ID:config/").remove(".config.json")
        FoodConfigStorage.put(name, config)
    }

    private fun <T> assertConfigProperty(input: T?, name: String): T {
        return input ?: throw RuntimeException("Missing $name in config; a crash may occur")
    }

    override fun getFabricId(): Identifier = Identifier(MOD_ID, "listener")
}

/**
 * The caching storage for data-driven FoodConfigs
 */
private object FoodConfigStorage {
    private val values: MutableMap<String, FoodConfig> = mutableMapOf()

    fun get(name: String): FoodConfig {
        return values.getOrDefault(name, FoodConfig.DEFAULT)
    }

    fun put(name: String, config: FoodConfig) {
        values[name] = config
    }

    fun clear(): Unit = values.clear()
}

/**
 * Gets a config from cache
 */
fun storedConfig(name: String) = FoodConfigStorage.get(name)

/**
 * Removes a [segment] from the string
 */
fun String.remove(segment: String): String = replace(segment, "")
