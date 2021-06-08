package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.MOD_ID
import com.redgrapefruit.utopia.common.module.Module
import com.redgrapefruit.utopia.common.module.ModuleFeature
import com.redgrapefruit.utopia.common.screen.handler.FFridgeScreenHandler
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier

/**
 * Furniture's screen handler registry
 */
object FScreenHandlerRegistry : ModuleFeature {
    override val module: Module = Module.FURNITURE
    override val isClientSide: Boolean = false

    lateinit var FRIDGE_SCREEN_HANDLER: ScreenHandlerType<FFridgeScreenHandler>

    override fun run()  {
        FRIDGE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(Identifier(MOD_ID, "fridge"), ::FFridgeScreenHandler)
    }
}