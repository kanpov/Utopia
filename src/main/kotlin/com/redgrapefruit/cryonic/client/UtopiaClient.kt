package com.redgrapefruit.cryonic.client

import com.redgrapefruit.cryonic.client.registry.ScreenRegistry
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment

@Environment(EnvType.CLIENT)
class UtopiaClient : ClientModInitializer {
    override fun onInitializeClient() {
        ScreenRegistry.run()
    }
}