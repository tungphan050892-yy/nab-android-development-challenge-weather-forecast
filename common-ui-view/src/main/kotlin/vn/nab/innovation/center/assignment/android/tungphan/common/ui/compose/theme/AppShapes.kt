package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

/**
 * Class representing wrapper for all shapes to be used inside Jetpack compose screens.
 * This class "mimics" shape.xml file as in Jetpack compose different sources of resources are used.
 */
data class AppShapes(val material: Shapes) {

    val small: CornerBasedShape get() = material.small
    val medium: CornerBasedShape get() = material.medium
    val large: CornerBasedShape get() = material.large

    internal companion object {
        val SmallRounded = RoundedCornerShape(4.dp)
        val MediumRounded = RoundedCornerShape(8.dp)
        val LargeRounded = RoundedCornerShape(
            topStart = 12.dp,
            topEnd = 12.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp,
        )
    }
}

// Set of Material shape styles.
private val Shapes = Shapes(
    small = AppShapes.SmallRounded,
    medium = AppShapes.MediumRounded,
    large = AppShapes.LargeRounded
)

// Set of Material color attributes for light theme.
internal val AppShapesWrapper = AppShapes(material = Shapes)

@Composable
internal fun ProvideAppShapes(
    shapes: AppShapes,
    content: @Composable () -> Unit
) {
    val rememberedShapes = remember { shapes }
    CompositionLocalProvider(LocalAppShapes provides rememberedShapes, content = content)
}

internal val LocalAppShapes = staticCompositionLocalOf { AppShapesWrapper }
