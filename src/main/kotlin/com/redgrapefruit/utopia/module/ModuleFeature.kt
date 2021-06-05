package com.redgrapefruit.utopia.module

/**
 * A plugin feature that can only be executed if a certain [Module] is enabled
 */
abstract class ModuleFeature {
    /**
     * The [Module] that this [ModuleFeature] belongs to
     */
    abstract val module: Module

    abstract fun run()

    companion object {
        /**
         * Contains all the registered [ModuleFeature]s
         */
        private val registeredFeatures: MutableList<ModuleFeature> = mutableListOf()

        /**
         * Executes all possible [ModuleFeature]s from given [ModuleConfig].
         *
         * Not a very performant solution, but it works fine
         */
        fun execute(config: ModuleConfig) {
            config.enabledModules.forEach { module ->
                registeredFeatures.forEach { feature ->
                    if (module == feature.module) {
                        feature.run()
                    }
                }
            }
        }
    }
}