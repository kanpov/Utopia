package com.redgrapefruit.utopia.client.registry

import com.redgrapefruit.utopia.client.screen.FridgeScreen
import com.redgrapefruit.utopia.common.registry.ScreenHandlerRegistry
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry

/**
 * Registry for game screens
 */
object ScreenRegistry {
    fun run() {
        ScreenRegistry.register(ScreenHandlerRegistry.FRIDGE_SCREEN_HANDLER, ::FridgeScreen)
    }
}