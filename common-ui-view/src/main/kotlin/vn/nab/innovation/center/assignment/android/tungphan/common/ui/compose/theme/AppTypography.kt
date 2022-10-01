package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.R

/**
 * Class representing wrapper for all text styles to be used inside Jetpack compose screens.
 * This class "mimics" type.xml file as in Jetpack compose different sources of resources are used.
 */
data class AppTypography(
    val material: Typography
) {
    val h1: TextStyle get() = material.h1
    val h2: TextStyle get() = material.h2
    val h3: TextStyle get() = material.h3
    val h4: TextStyle get() = material.h4
    val h5: TextStyle get() = material.h5
    val h6: TextStyle get() = material.h6
    val subtitle1: TextStyle get() = material.subtitle1
    val subtitle2: TextStyle get() = material.subtitle2
    val body1: TextStyle get() = material.body1
    val body2: TextStyle get() = material.body2
    val button: TextStyle get() = material.button
    val caption: TextStyle get() = material.caption
    val overline: TextStyle get() = material.overline

    internal companion object {
        // Families
        private val workSansFamily = FontFamily(
            Font(R.font.work_sans_bold, FontWeight.Bold)
        )

        // Styles.
        val h1 = TextStyle(
            fontFamily = FontFamily.Default,
            lineHeight = 40.sp,
            fontSize = 32.sp,
            color = AppColors.Greyscale20,
            fontWeight = FontWeight.Medium
        )
        val h2 = TextStyle(
            fontFamily = workSansFamily,
            lineHeight = 32.sp,
            fontSize = 24.sp,
            color = AppColors.Greyscale20,
            fontWeight = FontWeight.Medium
        )
        val h3 = TextStyle(
            lineHeight = 28.sp,
            fontSize = 20.sp,
            color = AppColors.Greyscale20,
            fontWeight = FontWeight.Medium
        )
        val h4 = TextStyle(
            lineHeight = 24.sp,
            fontSize = 18.sp,
            color = AppColors.Greyscale20,
            fontWeight = FontWeight.Medium
            // text all caps is false
        )
        val h5 = TextStyle(
            lineHeight = 20.sp,
            color = AppColors.Greyscale30,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            // text all caps is false
        )
        val h6 = TextStyle(
            color = AppColors.Greyscale20,
            lineHeight = 20.sp,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        val subtitle1 = TextStyle(
            color = AppColors.Greyscale60,
            lineHeight = 26.sp,
            fontSize = 12.sp
        )
        val subtitle2 = TextStyle()

        val body1 = TextStyle(
            color = AppColors.Greyscale20,
            lineHeight = 24.sp,
            fontSize = 16.sp
        )

        val body2 = TextStyle(
            color = AppColors.Greyscale50,
            lineHeight = 20.sp,
            fontSize = 14.sp
        )

        val button = TextStyle()

        val overline = TextStyle()
        val caption = TextStyle()
    }
}

// Set of Material typography styles to start with
private val Typography = Typography(
    h1 = AppTypography.h1,
    h2 = AppTypography.h2,
    h3 = AppTypography.h3,
    h4 = AppTypography.h4,
    h5 = AppTypography.h5,
    h6 = AppTypography.h6,
    subtitle1 = AppTypography.subtitle1,
    subtitle2 = AppTypography.subtitle2,
    body1 = AppTypography.body1,
    body2 = AppTypography.body2,
    button = AppTypography.button,
    caption = AppTypography.caption,
    overline = AppTypography.overline,
)

internal val AppTypographyWrapper = AppTypography(material = Typography)

@Composable
internal fun ProvideAppTypography(
    typography: AppTypography,
    content: @Composable () -> Unit
) {
    val rememberedTypography = remember { typography }
    CompositionLocalProvider(LocalAppTypography provides rememberedTypography, content = content)
}

internal val LocalAppTypography = staticCompositionLocalOf { AppTypographyWrapper }
