package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Class representing wrapper for all dimensions to be used inside Jetpack compose screens.
 * This class "mimics" dimens.xml file as in Jetpack compose different sources of resources are used.
 */
object AppDimensions {
    /**
     * 0.5 density pixels.
     */
    val ONE_SIXTEENTH_GRID_UNIT: Dp by lazy { 0.5f.dp }

    /**
     * 2 density pixels.
     */
    val QUARTER_GRID_UNIT: Dp by lazy { 2.dp }

    /**
     * 4 density pixels.
     */
    val HALF_GRID_UNIT: Dp by lazy { 4.dp }

    /**
     * 6 density pixels.
     */
    val THIRD_QUARTER_GRID_UNIT: Dp by lazy { 6.dp }

    /**
     * 8 density pixels.
     */
    val ONE_GRID_UNIT: Dp by lazy { 8.dp }

    /**
     * 12 density pixels.
     */
    val ONE_AND_HALF_GRID_UNIT: Dp by lazy { 12.dp }

    /**
     * 16 density pixels.
     */
    val TWO_GRID_UNIT: Dp by lazy { 16.dp }

    /**
     * 20 density pixels.
     */
    val TWO_AND_HALF_GRID_UNIT: Dp by lazy { 20.dp }

    /**
     * 24 density pixels.
     */
    val THREE_GRID_UNIT: Dp by lazy { 24.dp }

    /**
     * 28 density pixels.
     */
    val THREE_AND_HALF_GRID_UNIT: Dp by lazy { 28.dp }

    /**
     * 32 density pixels.
     */
    val FOUR_GRID_UNIT: Dp by lazy { 32.dp }

    /**
     * 40 density pixels.
     */
    val FIVE_GRID_UNIT: Dp by lazy { 40.dp }

    /**
     * 48 density pixels.
     */
    val SIX_GRID_UNIT: Dp by lazy { 48.dp }

    /**
     * 56 density pixels.
     */
    val SEVEN_GRID_UNIT: Dp by lazy { 56.dp }

    /**
     * 64 density pixels.
     */
    val EIGHT_GRID_UNIT: Dp by lazy { 64.dp }

    /**
     * 72 density pixels.
     */
    val NINE_GRID_UNIT: Dp by lazy { 72.dp }

    /**
     * 80 density pixels.
     */
    val TEN_GRID_UNIT: Dp by lazy { 80.dp }

    /**
     * 88 density pixels.
     */
    val ELEVEN_GRID_UNIT: Dp by lazy { 88.dp }

    /**
     * 96 density pixels.
     */
    val TWELVE_GRID_UNIT: Dp by lazy { 96.dp }

    /**
     * 112 density pixels.
     */
    val FOURTEEN_GRID_UNIT: Dp by lazy { 112.dp }

    /**
     * 128 density pixels
     */
    val SIXTEEN_GRID_UNIT: Dp by lazy { 128.dp }

    /**
     * 160 density pixels.
     */
    val TWENTY_GRID_UNIT: Dp by lazy { 160.dp }

    /**
     * 176 density pixels.
     */
    val TWENTY_TWO_GRID_UNIT: Dp by lazy { 176.dp }

    /**
     * 180 density pixels.
     */
    val TWENTY_TWO_AND_HALF_GRID_UNIT: Dp by lazy { 180.dp }

    /**
     * 280 density pixels.
     */
    val THIRTY_FIVE_GRID_UNIT: Dp by lazy { 280.dp }

    /**
     * 288 density pixels.
     */
    val THIRTY_SIX_GRID_UNIT: Dp by lazy { 288.dp }

    /**
     * 296 density pixels.
     */
    val THIRTY_SEVEN_GRID_UNIT: Dp by lazy { 296.dp }
}

internal val AppDimensionsWrapper = AppDimensions

@Composable
internal fun ProvideAppDimensions(
    dimensions: AppDimensions,
    content: @Composable () -> Unit
) {
    val rememberedDimensions = remember { dimensions }
    CompositionLocalProvider(LocalAppDimensions provides rememberedDimensions, content = content)
}

internal val LocalAppDimensions = staticCompositionLocalOf { AppDimensionsWrapper }
