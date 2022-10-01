package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colors = AppLightColorsWrapper // Add support for dark theme when needed!
    val typography = AppTypographyWrapper
    val dimensions = AppDimensionsWrapper
    val shapes = AppShapesWrapper

    ProvideAppColors(colors = AppLightColorsWrapper) {
        ProvideAppTypography(typography = typography) {
            ProvideAppShapes(shapes = shapes) {
                ProvideAppDimensions(dimensions = dimensions) {
                    MaterialTheme(
                        colors = colors.material,
                        typography = typography.material,
                        shapes = shapes.material,
                        content = content
                    )
                }
            }
        }
    }
}
