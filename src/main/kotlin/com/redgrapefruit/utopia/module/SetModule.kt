package com.redgrapefruit.utopia.module

/**
 * Marks the [Module] that the class/interface/object etc. belongs to.
 *
 * Unlike [ModuleFeature], this is for decorative purposes only (to make the code cleaner and more understandable).
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class SetModule(val module: Module)
