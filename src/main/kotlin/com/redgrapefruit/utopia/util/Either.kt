package com.redgrapefruit.utopia.util

/**
 * A data structure containing either [A] or [B].
 *
 * The main advantage: no errors have to be thrown in order to operate on these optional values
 *
 * The main disadvantage: even after calling [isFirstPresent] or [isSecondPresent], you have to put `!!` after referencing the object
 */
data class Either<A, B>(
    /**
     * The stored [A]. Null by default
     */
     var first: A? = null,
     /**
      * The stored [B]. Null by default
      */
     var second: B? = null) {

    // Checks
    fun isFirstPresent(): Boolean = first != null
    fun isSecondPresent(): Boolean = second != null
    fun areNeitherPresent(): Boolean = first == null && second == null

    // Apply
    inline fun first(action: () -> A): Either<A, B> {
        first = action.invoke()
        return this
    }
    inline fun second(action: () -> B): Either<A, B> {
        second = action.invoke()
        return this
    }
}