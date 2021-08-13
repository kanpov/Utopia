@file:JvmName("ConfigDataKt")

package com.redgrapefruit.utopia.common.io

import com.redgrapefruit.utopia.common.*
import com.redgrapefruit.utopia.common.core.FoodCategory
import com.redgrapefruit.utopia.common.core.FoodConfig
import com.redgrapefruit.utopia.common.core.config
import kotlinx.serialization.json.*
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.fabricmc.fabric.api.resource.ResourceManagerHelper
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener
import net.minecraft.resource.ResourceManager
import net.minecraft.resource.ResourceType
import net.minecraft.util.Identifier
import java.io.InputStream
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

// <----  Managing data-driven FoodConfigs  ---->

private const val NO_PARENT = "no_parent"

/**
 * (Re)loads [FoodConfig]s
 */
object FoodConfigReloader : SimpleSynchronousResourceReloadListener {
    fun register() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(FoodConfigReloader)
    }

    override fun reload(manager: ResourceManager) {
        // Clear all caches to reload them
        cache.clear()
        manager.findResources("config") { path -> path.endsWith(".config.json") }.forEach { id ->
            process(manager.getResource(id).inputStream, id)
        }
    }

    private fun process(input: InputStream, id: Identifier) {
        // Obtain the name of the food (utopia:config/almond.config.json => almond)
        val name = id.toString().remove("$MOD_ID:config/").remove(".config.json")

        // Read JsonObject
        val jsonObject: JsonObject
        input.use { stream ->
            jsonObject = Json.decodeFromString(JsonObject.serializer(), stream.readBytes().decodeToString())
        }

        // Parse everything

        // Inheritance
        val parentKey = if (jsonObject.contains("parent")) jsonObject["parent"]!!.jsonPrimitive.content else NO_PARENT
        val parent = BASE_COMPONENT_MAP[parentKey]

        // FoodCategory. This also determines which properties are required afterwards
        val category = FoodCategory.fromString(
            assertConfigProperty(jsonObject["category"], "category", name).jsonPrimitive.content)
        // Rot values
        var rotSpeed = UNUSED_PROPERTY
        var rotState = UNUSED_PROPERTY
        if (category.canRot) {
            rotSpeed = assertConfigProperty(jsonObject["rotSpeed"], "rotSpeed", name).jsonPrimitive.int
            rotState = assertConfigProperty(jsonObject["rotState"], "rotState", name).jsonPrimitive.int
        }
        // Overdue values
        var overdueSpeed = UNUSED_PROPERTY
        var overdueState = UNUSED_PROPERTY
        if (category.canOverdue) {
            overdueSpeed = assertConfigProperty(jsonObject["overdueSpeed"], "overdueSpeed", name).jsonPrimitive.int
            overdueState = assertConfigProperty(jsonObject["overdueState"], "overdueState", name).jsonPrimitive.int
        }
        // Fridge
        var fridgeEfficiency = UNUSED_PROPERTY
        if (category.canBePutInFridge) {
            fridgeEfficiency = assertConfigProperty(jsonObject["fridgeEfficiency"], "fridgeEfficiency", name).jsonPrimitive.int
        }
        // Salt
        val saltEfficiency =
            if (jsonObject.contains("saltEfficiency")) jsonObject["saltEfficiency"]!!.jsonPrimitive.int else UNUSED_PROPERTY
        // Hunger & Saturation
        val hunger =
            if (jsonObject.contains("hunger")) jsonObject["hunger"]!!.jsonPrimitive.int else ZERO_INT
        val saturationModifier =
            if (jsonObject.contains("saturationModifier")) jsonObject["saturationModifier"]!!.jsonPrimitive.float else ZERO_FLOAT

        // Construct config using the DSL
        val config = config {
            this.category = category
            if (rotSpeed != UNUSED_PROPERTY) this.rotSpeed = rotSpeed
            if (rotState != UNUSED_PROPERTY) this.rotState = rotState
            if (overdueSpeed != UNUSED_PROPERTY) this.overdueSpeed = overdueSpeed
            if (overdueState != UNUSED_PROPERTY) this.overdueState = overdueState
            if (fridgeEfficiency != UNUSED_PROPERTY) this.fridgeEfficiency = fridgeEfficiency
            if (saltEfficiency != UNUSED_PROPERTY) this.saltEfficiency = saltEfficiency
            if (hunger != UNUSED_PROPERTY) {
                var parentValue = ZERO_INT
                if (parentKey != NO_PARENT) parentValue = parent!!.hunger
                this.hunger = parentValue + hunger
            }
            if (saturationModifier != UNUSED_PROPERTY_FLOAT) {
                var parentValue = ZERO_FLOAT
                if (parentKey != NO_PARENT) parentValue = parent!!.saturationModifier
                this.saturationModifier = parentValue + saturationModifier
            }
        }

        // Cache the config and invoke event for the corresponding item to prepare its FoodComponent
        cache[name] = config
        ComponentInitializeCallback.Event.invoker().init(name, config)
    }

    private fun <T> assertConfigProperty(input: T?, name: String, foodName: String): T {
        return input ?: throw RuntimeException("Missing $name in config for ${foodName.replace("_", " ")}; a crash may occur")
    }

    override fun getFabricId(): Identifier = Identifier(MOD_ID, "listener")
}

/**
 * Caches containing loaded configs. Cleared on every reload
 */
private val cache = mutableMapOf<String, FoodConfig>()

/**
 * Gets a config from cache
 */
fun storedConfig(name: String) = cache.getOrDefault(name, FoodConfig.Default)

/**
 * A delegate that recalls [supplier] each time used.
 *
 * That allows to query the value each time it's needed since the value can update
 * (like with the cached config system).
 *
 * Instantiate via [reloaderDelegate].
 */
class ConfigReloaderDelegate(private val supplier: () -> FoodConfig) : ReadOnlyProperty<Any, FoodConfig> {
    override fun getValue(thisRef: Any, property: KProperty<*>): FoodConfig = supplier()
}

fun reloaderDelegate(supplier: () -> FoodConfig): ConfigReloaderDelegate {
    return ConfigReloaderDelegate(supplier)
}

/**
 * Removes a [segment] from the string
 */
fun String.remove(segment: String): String = replace(segment, "")

/**
 * Allows you to prepare a component for food once the config is loaded in
 */
interface ComponentInitializeCallback {
    fun init(name: String, config: FoodConfig)

    companion object {
        val Event: Event<ComponentInitializeCallback> = EventFactory.createArrayBacked(ComponentInitializeCallback::class.java)
        { listeners: Array<ComponentInitializeCallback> ->
            Impl { name, config ->
                listeners.forEach { listener -> listener.init(name, config) }
            }
        }

        /**
         * Create a lambda listener for the event
         */
        fun listener(action: (String, FoodConfig) -> Unit) = Impl(action)
    }

    /**
     * Wrapper implementation for lambda listeners. Use [listener] to create.
     */
    class Impl(private val action: (String, FoodConfig) -> Unit) : ComponentInitializeCallback {
        override fun init(name: String, config: FoodConfig) = action(name, config)
    }
}
