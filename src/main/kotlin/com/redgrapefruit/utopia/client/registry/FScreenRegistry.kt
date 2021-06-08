package com.redgrapefruit.utopia.client.registry

import com.redgrapefruit.utopia.common.module.Module
import com.redgrapefruit.utopia.common.module.ModuleFeature

object FScreenRegistry : ModuleFeature {
    override val module: Module = Module.FURNITURE
    override val isClientSide: Boolean = true

    override fun run() {

    }
}