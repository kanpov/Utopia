package com.redgrapefruit.utopia.common.util

/**
 * A data structure containing either [TFirst] or [TSecond].
 *
 * The main advantage: no errors have to be thrown in order to operate on these optional values
 *
 * The main disadvantage: even after calling [isFirstPresent] or [isSecondPresent], you have to put `!!` after referencing the object
 */
data class Either<TFirst, TSecond>(
    /**
     * The stored [TFirst]. Null by default
     */
     var first: TFirst? = null,
     /**
      * The stored [TSecond]. Null by default
      */
     var second: TSecond? = null) {

    // Checks
    fun isFirstPresent(): Boolean = first != null
    fun isSecondPresent(): Boolean = second != null
    fun areNeitherPresent(): Boolean = first == null && second == null

    // Apply
    inline fun first(action: () -> TFirst): Either<TFirst, TSecond> {
        first = action.invoke()
        return this
    }
    inline fun second(action: () -> TSecond): Either<TFirst, TSecond> {
        second = action.invoke()
        return this
    }
}