package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.MOD_ID
import com.redgrapefruit.utopia.common.screen.handler.FridgeScreenHandler
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier

/**
 * Furniture's screen handler registry
 */
object ScreenHandlerRegistry {
    lateinit var FRIDGE_SCREEN_HANDLER: ScreenHandlerType<FridgeScreenHandler>

    fun run() {
        FRIDGE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(Identifier(MOD_ID, "fridge"), ::FridgeScreenHandler)
    }
}