package com.redgrapefruit.utopia.common

import com.redgrapefruit.utopia.common.io.FoodConfigReloader
import com.redgrapefruit.utopia.common.io.loadConfig
import com.redgrapefruit.utopia.common.registry.PatchRegistry
import com.redgrapefruit.utopia.common.registry.BlockRegistry
import com.redgrapefruit.utopia.common.registry.ItemRegistry
import com.redgrapefruit.utopia.common.registry.ScreenHandlerRegistry
import net.fabricmc.api.ModInitializer

class Utopia : ModInitializer {
    override fun onInitialize() {
        loadConfig()
        FoodConfigReloader.register()

        ItemRegistry.run()
        BlockRegistry.run()
        PatchRegistry.run()
        ScreenHandlerRegistry.run()
    }
}