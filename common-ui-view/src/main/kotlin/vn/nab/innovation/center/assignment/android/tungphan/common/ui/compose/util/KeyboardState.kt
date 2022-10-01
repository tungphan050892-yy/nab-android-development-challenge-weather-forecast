package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.util

import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.util.Keyboard.Closed
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.util.Keyboard.Opened

enum class Keyboard {
    Opened, Closed
}

/**
 * Emits a new state whenever keyboard is opened/closed
 */
@Composable
fun keyboardAsState(): State<Keyboard> {
    val keyboardState = remember { mutableStateOf(Closed) }
    val view = LocalView.current
    DisposableEffect(view) {
        val onGlobalListener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            insets?.let { safeInsets ->
                keyboardState.value = if (safeInsets.isVisible(WindowInsetsCompat.Type.ime())) {
                    Opened
                } else {
                    Closed
                }
            }
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(onGlobalListener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalListener)
        }
    }

    return keyboardState
}
