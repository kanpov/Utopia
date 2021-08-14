package com.redgrapefruit.utopia

import com.redgrapefruit.utopia.util.FoodConfigReloader
import com.redgrapefruit.utopia.registry.PatchRegistry
import com.redgrapefruit.utopia.registry.BlockRegistry
import com.redgrapefruit.utopia.registry.ItemRegistry
import com.redgrapefruit.utopia.registry.ScreenHandlerRegistry
import com.redgrapefruit.utopia.util.loadConfig
import net.fabricmc.api.ModInitializer

class Utopia : ModInitializer {
    override fun onInitialize() {
        FoodConfigReloader.register()
        loadConfig()

        ItemRegistry.run()
        BlockRegistry.run()
        PatchRegistry.run()
        ScreenHandlerRegistry.run()
    }
}