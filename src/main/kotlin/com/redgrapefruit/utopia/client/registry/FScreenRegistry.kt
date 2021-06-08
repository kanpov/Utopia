package com.redgrapefruit.utopia.client.registry

import com.redgrapefruit.utopia.client.screen.FFridgeScreen
import com.redgrapefruit.utopia.common.module.Module
import com.redgrapefruit.utopia.common.module.ModuleFeature
import com.redgrapefruit.utopia.common.registry.FScreenHandlerRegistry
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry

object FScreenRegistry : ModuleFeature {
    override val module: Module = Module.FURNITURE
    override val isClientSide: Boolean = true

    override fun run() {
        ScreenRegistry.register(FScreenHandlerRegistry.FRIDGE_SCREEN_HANDLER, ::FFridgeScreen)
    }
}