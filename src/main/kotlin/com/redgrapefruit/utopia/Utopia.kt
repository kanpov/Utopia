package com.redgrapefruit.utopia

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.redgrapefruit.utopia.module.ModuleConfig
import com.redgrapefruit.utopia.module.ModuleFeature
import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class Utopia : ModInitializer {
    override fun onInitialize() {
        // First, initialize the ModuleConfig
        ModuleFeature.executeAll(ModuleConfig.init())
    }

    companion object {
        val LOG: Logger = LogManager.getLogger()

        val GSON: Gson = GsonBuilder().setPrettyPrinting().create()
    }
}