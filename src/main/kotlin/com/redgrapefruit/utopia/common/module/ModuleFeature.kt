package com.redgrapefruit.utopia.common.module

import com.redgrapefruit.utopia.common.registry.FBlockRegistry
import com.redgrapefruit.utopia.common.registry.FScreenHandlerRegistry
import com.redgrapefruit.utopia.common.registry.RItemRegistry
import com.redgrapefruit.utopia.common.registry.RPatchRegistry
import net.fabricmc.api.Environment

/**
 * A plugin feature that can only be executed if a certain [Module] is enabled
 */
interface ModuleFeature {
    /**
     * The [Module] that this [ModuleFeature] belongs to
     */
    val module: Module

    /**
     * Is this [ModuleFeature] client-side only
     */
    val isClientSide: Boolean

    fun run()

    companion object {
        /**
         * Contains all the registered [ModuleFeature]s
         */
        private val registeredFeatures: List<ModuleFeature> = listOf(
            RItemRegistry,
            RPatchRegistry,
            FBlockRegistry,
            FScreenHandlerRegistry
        )

        /**
         * Executes all non-client-side [ModuleFeature]s from given [ModuleConfig].
         *
         * Not a very performant solution, but it works fine
         */
        fun executeCommon(config: ModuleConfig) {
            config.enabledModules.forEach { module ->
                registeredFeatures.forEach { feature ->
                    if (module == feature.module && !feature.isClientSide) {
                        feature.run()
                    }
                }
            }
        }

        fun executeClient(config: ModuleConfig) {
            config.enabledModules.forEach { module ->
                registeredFeatures.forEach { feature ->
                    if (module == feature.module && feature.isClientSide) {
                        feature.run()
                    }
                }
            }
        }
    }
}