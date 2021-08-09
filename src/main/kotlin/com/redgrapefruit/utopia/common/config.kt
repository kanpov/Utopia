package com.redgrapefruit.utopia.common

import kotlinx.serialization.json.*
import net.fabricmc.loader.api.FabricLoader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * An enum of all the mod's modules
 */
enum class Module(internal val jsonEquivalent: String) {
    REALISM("realism"),
    FURNITURE("furniture"),
    STORAGE("storage"),
    WORLDGEN("worldgen"),
    BUILDING("building"),
    COOKING("cooking")
}

/**
 * The enabled modules
 */
private val modules: MutableMap<Module, Boolean> = mutableMapOf()

/**
 * Loads the mod's module configuration
 */
fun loadConfig() {
    // Verify config directory
    val configDir = File(FabricLoader.getInstance().configDir.toFile(), MOD_ID)
    if (!configDir.exists()) configDir.mkdirs()

    // Verify options file, create it with defaults (true) if needed
    val optionsFile = File(configDir, "config.json")
    if (!optionsFile.exists()) {
        optionsFile.createNewFile()

        val jsonObject = buildJsonObject {
            Module.values().forEach { value ->
                put(value.jsonEquivalent, JsonPrimitive(true))
            }
        }
        FileOutputStream(optionsFile).use { stream ->
            stream.write(Json.encodeToString(JsonObject.serializer(), jsonObject).encodeToByteArray())
        }
    }

    // Load up the config now
    val jsonObject: JsonObject
    FileInputStream(optionsFile).use { stream ->
        jsonObject = Json.decodeFromString(JsonObject.serializer(), stream.readBytes().decodeToString())
    }
    Module.values().forEach { value ->
        modules[value] = jsonObject[value.jsonEquivalent]!!.jsonPrimitive.boolean
    }
}

/**
 * Allows the user to access [modules] indirectly and set values
 */
fun setConfigProperty(property: Module, value: Boolean) {
    modules[property] = value
}

/**
 * Saves the current state of the [modules] variable to the config.
 *
 * **Must not be run before [loadConfig]**
 */
fun saveConfig() {
    // Delete the options file and then recreate it
    val configDir = File(FabricLoader.getInstance().configDir.toFile(), MOD_ID)
    val optionsFile = File(configDir, "config.json")
    optionsFile.delete()
    optionsFile.createNewFile()

    // Rewrite it
    val jsonObject = buildJsonObject {
        modules.forEach { (key, value) ->
            put(key.jsonEquivalent, JsonPrimitive(value))
        }
    }
    FileOutputStream(optionsFile).use { stream ->
        stream.write(Json.encodeToString(JsonObject.serializer(), jsonObject).encodeToByteArray())
    }
}
