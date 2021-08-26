package com.redgrapefruit.cryonic.registry

import com.redgrapefruit.cryonic.MOD_ID
import com.redgrapefruit.cryonic.screen.handler.FridgeScreenHandler
import com.redgrapefruit.cryonic.util.IRegistry
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier

/**
 * Furniture's screen handler registry
 */
object ScreenHandlerRegistry : IRegistry {
    lateinit var FRIDGE_SCREEN_HANDLER: ScreenHandlerType<FridgeScreenHandler>

    override fun run() {
        FRIDGE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(Identifier(MOD_ID, "fridge"), ::FridgeScreenHandler)
    }
}