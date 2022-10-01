package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Class representing wrapper for all colors to be used inside Jetpack compose screens.
 * This class "mimics" colors.xml file as in Jetpack compose different sources of resources are used.
 */
data class AppColors(
    val material: Colors
) {
    val primary: Color get() = material.primary
    val primaryVariant: Color get() = material.primaryVariant
    val secondary: Color get() = material.secondary
    val secondaryVariant: Color get() = material.secondaryVariant
    val background: Color get() = material.background
    val surface: Color get() = material.surface
    val error: Color get() = material.error
    val onPrimary: Color get() = material.onPrimary
    val onSecondary: Color get() = material.onSecondary
    val onBackground: Color get() = material.onBackground
    val onSurface: Color get() = material.onSurface
    val onError: Color get() = material.onError
    val primarySurface: Color get() = material.primarySurface

    // Specific colors which are exposed.
    val red50: Color get() = Red50
    val base40: Color get() = Base50
    val base50: Color get() = Base50
    val base60: Color get() = Base60
    val base80: Color get() = Base80
    val base98: Color get() = Base98
    val white: Color get() = White
    val black: Color get() = Black
    val transparent: Color get() = Transparent
    val greyscale20: Color get() = Greyscale20
    val greyscale30: Color get() = Greyscale30
    val greyscale40: Color get() = Greyscale40
    val greyscale50: Color get() = Greyscale50
    val greyscale60: Color get() = Greyscale60
    val greyscale70: Color get() = Greyscale70
    val greyscale80: Color get() = Greyscale80
    val greyscale85: Color get() = Greyscale85
    val greyscale90: Color get() = Greyscale90
    val greyscale95: Color get() = Greyscale95

    val disabled: Color get() = Greyscale85

    internal companion object {
        val White = Color.White
        val Black = Color.Black
        val Transparent = Color.Transparent

        val Red60 = Color(0XFFB00020)
        val Red50 = Color(0XFFED2C28)
        val Red40 = Color(0XFFBC2320)

        val Blue50 = Color(0XFF0099E5)
        val Blue40 = Color(0XFF007AB7)

        val Greyscale00 = Black
        val Greyscale20 = Color(0XFF333333)
        val Greyscale30 = Color(0XFF4D4D4D)
        val Greyscale40 = Color(0XFF666666)
        val Greyscale45 = Color(0XFF6A6A6A)
        val Greyscale50 = Color(0XFF808080)
        val Greyscale60 = Color(0XFF999999)
        val Greyscale70 = Color(0XFFB2B2B2)
        val Greyscale75 = Color(0XFFBFBFBF)
        val Greyscale80 = Color(0XFFCCCCCC)
        val Greyscale85 = Color(0XFFD9D9D9)
        val Greyscale90 = Color(0XFFE5E5E5)
        val Greyscale95 = Color(0XFFF2F2F2)

        val Base20 = Color(0XFFE6ECF2)
        val Base40 = Color(0xFF425366)
        val Base50 = Color(0XFF596b80)
        val Base60 = Color(0XFF738499)
        val Base80 = Color(0XFFADBBCC)
        val Base98 = Color(0XFFF5F6F7)
    }
}

// Color palette for 'normal'/light mode
private val LightColorPalette = lightColors(
    primary = AppColors.Red50,
    primaryVariant = AppColors.Red40,
    secondary = AppColors.Blue50,
    secondaryVariant = AppColors.Blue40,
    background = AppColors.Greyscale95,
    surface = AppColors.White,
    error = AppColors.Red60,
    onSurface = AppColors.Black,
    onPrimary = AppColors.Greyscale95,
    onSecondary = AppColors.Greyscale60,
    onBackground = AppColors.Greyscale30,
    onError = AppColors.White,
)

// Set of Material color attributes for light theme.
internal val AppLightColorsWrapper = AppColors(material = LightColorPalette)

@Composable
internal fun ProvideAppColors(
    colors: AppColors,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors }
    CompositionLocalProvider(LocalAppColors provides rememberedColors, content = content)
}

internal val LocalAppColors = staticCompositionLocalOf { AppLightColorsWrapper }
