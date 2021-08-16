package com.redgrapefruit.utopia

import com.redgrapefruit.utopia.registry.*
import com.redgrapefruit.utopia.util.FoodConfigReloader
import com.redgrapefruit.utopia.util.loadConfig
import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

val LOG: Logger = LogManager.getLogger()

class Utopia : ModInitializer {
    override fun onInitialize() {
        FoodConfigReloader.register()
        loadConfig()

        FoodRegistry.run()
        DrinkRegistry.run()
        BlockRegistry.run()
        PatchRegistry.run()
        ScreenHandlerRegistry.run()
    }
}