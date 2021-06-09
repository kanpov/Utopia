package com.redgrapefruit.utopia.common.module

import com.google.gson.JsonObject
import com.redgrapefruit.utopia.common.GSON
import com.redgrapefruit.utopia.common.LOG
import net.fabricmc.loader.FabricLoader
import java.io.*

/**
 * A (de)serialized configuration file with all enabled [Module]s.
 */
object ModuleConfig {
    /**
     * A list of all enabled [Module]s
     */
    internal val enabledModules: MutableList<Module> = mutableListOf()

    /**
     * Initializes the configuration file
     */
    fun init(): ModuleConfig {
        // Get the Minecraft config directory (on Windows 10 C:/Users/$USERNAME$/AppData/Local/.minecraft/config)
        val configDir = FabricLoader.INSTANCE.configDir.toFile()
        // If it doesn't exist, create it
        if (!configDir.exists()) {
            LOG.info("Config directory doesn't exist; Creating it...")
            configDir.mkdirs()
        }

        // Create the module settings JSON
        val optionsFile = File(configDir, "utopia.modules.json")
        // If the JSON doesn't exist, create it and fill it up with default values
        if (!optionsFile.exists()) {
            return try {
                val writer = FileWriter(optionsFile)
                setToDefault(writer, optionsFile)
                this
            } catch (exception: Exception) {
                // Error out if couldn't create the FileWriter
                LOG.error("Couldn't create FileWriter for the options file with the following stack trace:")
                exception.printStackTrace()
                this
            }
        }

        // If we are here, we assume that the file already contained something, so we read its contents
        // Create a FileReader
        try {
            val reader = FileReader(optionsFile)
            setToExisting(reader, optionsFile)
        } catch (exception: Exception) {
            // Error out if couldn't create the FileReader
            LOG.error("Couldn't create FileReader for the options file with the following stack trace:")
            exception.printStackTrace()
        }

        return this
    }

    /**
     * Sets the values to already existing in the configuration file
     * @param reader [Reader] for this file
     */
    private fun setToExisting(reader: Reader, optionsFile: File) {
        LOG.info("Importing options file at location ${optionsFile.absolutePath}")

        val jsonObject = GSON.fromJson(reader, JsonObject::class.java)

        // Initialize each module with the value from the JsonObject
        set(Module.REALISM, jsonObject)
        set(Module.FURNITURE, jsonObject)
        set(Module.EXPLORATION, jsonObject)
        set(Module.BUILDING, jsonObject)
        set(Module.COOKING, jsonObject)
    }

    /**
     * Sets the values in the configuration file to defaults (all true)
     * @param writer [Writer] for this file
     */
    private fun setToDefault(writer: Writer, optionsFile: File) {
        LOG.info("Couldn't import options file. Creating a new one at location ${optionsFile.absolutePath}")

        val jsonObject = JsonObject()

        // Add comments to guide the user
        jsonObject.addProperty(
            "_guide_1",
            "For each module, set the value to true to enable the module and to false to disable it"
        )
        jsonObject.addProperty(
            "_guide_2",
            "After setting a new value, make sure to restart Minecraft to apply the changes since the config reloads every launch of the game"
        )

        // Initialize each module with true
        enable(Module.REALISM, jsonObject)
        enable(Module.FURNITURE, jsonObject)
        enable(Module.EXPLORATION, jsonObject)
        enable(Module.BUILDING, jsonObject)
        enable(Module.COOKING, jsonObject)

        // Write to file
        GSON.toJson(jsonObject, writer)

        writer.close()
    }

    private fun enable(module: Module, jsonObject: JsonObject) {
        jsonObject.addProperty(module.equivalent, true)

        LOG.info("Module '${module.equivalent}' is enabled")
        enabledModules.add(module)
    }

    private fun set(module: Module, jsonObject: JsonObject) {
        val enabled = jsonObject.get(module.equivalent).asBoolean

        if (enabled) {
            LOG.info("Module '${module.equivalent}' is enabled")
            enabledModules.add(module)
        } else {
            LOG.info("Module '${module.equivalent}' is disabled")
        }
    }
}