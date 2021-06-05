package com.redgrapefruit.utopia.module

/**
 * Marks the [Module] that the class/interface/object etc. belongs to.
 *
 * Unlike [ModuleFeature], this is for decorative purposes only (to make the code cleaner and more understandable).
 *
 * As a convention, every class/interface/object etc. (except mod initializers and [ModuleFeature]s) should be marked with [SetModule]
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class SetModule(val module: Module)
