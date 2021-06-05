package com.redgrapefruit.utopia.module

import com.google.gson.JsonObject
import com.redgrapefruit.utopia.Utopia
import net.fabricmc.loader.FabricLoader
import java.io.*

/**
 * A (de)serialized configuration file with all enabled [Module]s.
 *
 * You shouldn't edit the file directly, but use commands (TBD).
 */
object ModuleConfig {
    /**
     * A list of all enabled [Module]s
     */
    internal val enabledModules: MutableList<Module> = mutableListOf()

    /**
     * Initializes the configuration file
     */
    fun init() {
        // Get the Minecraft config directory (on Windows 10 C:/Users/$USERNAME$/AppData/Local/.minecraft/config)
        val configDir: File = FabricLoader.INSTANCE.configDir.toFile()
        // If it doesn't exist, create it
        if (!configDir.exists()) configDir.mkdirs()

        // Create the module settings JSON
        val optionsFile: File = File(configDir, "utopia.modules.json")
        // If the JSON doesn't exist, create it and fill it up with default values
        if (!optionsFile.exists()) {
            try {
                val writer = FileWriter(optionsFile)
                setToDefault(writer)
                return
            } catch (exception: Exception) {
                // Error out if couldn't create the FileWriter
                Utopia.LOG.error("Couldn't create FileWriter for the options file with the following stack trace:")
                exception.printStackTrace()
                return
            }
        }

        // If we are here, we assume that the file already contained something, so we read its contents
        // Create a FileReader
        try {
            val reader = FileReader(optionsFile)
            setToExisting(reader)
        } catch (exception: Exception) {
            // Error out if couldn't create the FileReader
            Utopia.LOG.error("Couldn't create FileReader for the options file with the following stack trace:")
            exception.printStackTrace()
        }
    }

    /**
     * Sets the values to already existing in the configuration file
     * @param reader [Reader] for this file
     */
    private fun setToExisting(reader: Reader) {
        val jsonObject = Utopia.GSON.fromJson(reader, JsonObject::class.java)

        // Initialize each module with the value from the JsonObject
        set("realism", Module.REALISM, jsonObject)
        set("furniture", Module.FURNITURE, jsonObject)
        set("exploration", Module.EXPLORATION, jsonObject)
        set("building", Module.BUILDING, jsonObject)
        set("cooking", Module.COOKING, jsonObject)
    }

    /**
     * Sets the values in the configuration file to defaults (all true)
     * @param writer [Writer] for this file
     */
    private fun setToDefault(writer: Writer) {
        val jsonObject = JsonObject()

        // Add comments to guide the user
        jsonObject.addProperty("_guide_1", "For each module, set the value to true to enable the module and to false to disable it")
        jsonObject.addProperty("_guide_2", "After setting a new value, make sure to restart Minecraft to apply the changes since the config reloads every launch of the game")

        // Initialize each module with true
        enable("realism", Module.REALISM, jsonObject)
        enable("furniture", Module.FURNITURE, jsonObject)
        enable("exploration", Module.EXPLORATION, jsonObject)
        enable("building", Module.BUILDING, jsonObject)
        enable("cooking", Module.COOKING, jsonObject)

        // Write to file
        Utopia.GSON.toJson(jsonObject, writer)

        writer.close()
    }

    private fun enable(name: String, module: Module, jsonObject: JsonObject) {
        jsonObject.addProperty(name, true)

        enabledModules.add(module)
    }

    private fun set(name: String, module: Module, jsonObject: JsonObject) {
        val enabled = jsonObject.get(name).asBoolean

        if (enabled) enabledModules.add(module)
    }
}