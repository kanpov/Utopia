package com.redgrapefruit.utopia.client

import com.redgrapefruit.utopia.client.registry.ScreenRegistry
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment

@Environment(EnvType.CLIENT)
class UtopiaClient : ClientModInitializer {
    override fun onInitializeClient() {
        ScreenRegistry.run()
    }
}