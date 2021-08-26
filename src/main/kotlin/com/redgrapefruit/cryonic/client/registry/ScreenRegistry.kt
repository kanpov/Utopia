package com.redgrapefruit.cryonic.client.registry

import com.redgrapefruit.cryonic.client.screen.FridgeScreen
import com.redgrapefruit.cryonic.registry.ScreenHandlerRegistry
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry

/**
 * Registry for game screens
 */
object ScreenRegistry {
    fun run() {
        ScreenRegistry.register(ScreenHandlerRegistry.FRIDGE_SCREEN_HANDLER, ::FridgeScreen)
    }
}