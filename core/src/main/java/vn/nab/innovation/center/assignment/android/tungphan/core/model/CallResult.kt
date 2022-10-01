package vn.nab.innovation.center.assignment.android.tungphan.core.model

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

data class CallResult<T> internal constructor(
    internal val value: Any?
) {

    /**
     * Returns `true` if this instance represents successful outcome.
     * In this case [isFailure] returns `false`.
     */
    val isSuccess: Boolean get() = value !is Failure

    /**
     * Returns `true` if this instance represents failed outcome.
     * In this case [isSuccess] returns `false`.
     */
    val isFailure: Boolean get() = value is Failure

    fun getOrNull(): T? =
        when {
            isFailure -> null
            else -> value as T
        }

    /**
     * Returns the encapsulated exception if this instance represents [failure][isFailure] or `null`
     * if it is [success][isSuccess].
     *
     * This function is shorthand for `fold(onSuccess = { null }, onFailure = { it })` (see [fold]).
     */
    fun exceptionOrNull(): Throwable? =
        when (value) {
            is Failure -> value.exception
            else -> null
        }

    override fun toString(): String {
        return value.toString()
    }

    /**
     * Companion object for [CallResult] class that contains its constructor functions
     * [success] and [failure].
     */
    companion object {
        /**
         * Returns an instance that encapsulates the given [value] as successful value.
         */
        fun <T> success(value: T): CallResult<T> =
            CallResult(value)

        /**
         * Returns an instance that encapsulates the given [exception] as failure.
         */
        fun <T> failure(exception: Throwable): CallResult<T> =
            CallResult(createFailure(exception))
    }

    internal class Failure(
        @JvmField
        val exception: Throwable
    ) {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }
}

internal fun createFailure(exception: Throwable): Any = CallResult.Failure(exception)

internal fun CallResult<*>.throwOnFailure() {
    if (value is CallResult.Failure) throw value.exception
}

fun <T> CallResult<T>.getOrThrow(): T {
    throwOnFailure()
    return value as T
}

@ExperimentalContracts
inline fun <T> CallResult<T>.onFailure(action: (exception: Throwable) -> Unit): CallResult<T> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    exceptionOrNull()?.let { action(it) }
    return this
}
