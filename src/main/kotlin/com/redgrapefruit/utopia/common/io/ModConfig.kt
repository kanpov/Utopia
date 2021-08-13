package com.redgrapefruit.utopia.common.io

import com.redgrapefruit.utopia.common.MOD_ID
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
 * The enabled modules.
 *
 * Do **not** access this directly!
 */
val modules: MutableMap<Module, Boolean> = mutableMapOf()

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
 * Executes module-specific code if that [module] is enabled
 */
fun moduleSpecific(module: Module, action: () -> Unit) {
    if (modules[module]!!) action()
}
