package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.util

/**
 * Sealed class responsible for handling input state.
 */
sealed class InputFieldState<out T> {
    object Idle : InputFieldState<Nothing>()
    data class InputChanged<T>(val value: T) : InputFieldState<T>()
}
