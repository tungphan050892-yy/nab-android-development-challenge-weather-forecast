package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme

@Composable
fun ErrorSnackBar(snackBarData: SnackbarData) {
    Snackbar(
        modifier = Modifier.padding(AppTheme.dimensions.ONE_AND_HALF_GRID_UNIT),
        action = {
            TextButton(onClick = { snackBarData.performAction() }) {
                Text(
                    text = "${snackBarData.actionLabel?.uppercase()}",
                    style = AppTheme.typography.button,
                    color = AppTheme.colors.secondary
                )
            }
        },
        content = {
            Text(text = snackBarData.message, color = AppTheme.colors.white)
        }
    )
}
