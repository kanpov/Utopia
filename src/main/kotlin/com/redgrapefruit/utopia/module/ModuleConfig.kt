package com.redgrapefruit.utopia.module

/**
 * A (de)serialized configuration file with all enabled [Module]s.
 *
 * You shouldn't edit the file directly, but use commands (TBD).
 */
object ModuleConfig {
    /**
     * A list of all enabled [Module]s
     */
    internal val enabledModules: MutableList<Module> = mutableListOf()


}