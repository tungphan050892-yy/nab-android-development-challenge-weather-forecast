package vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppColors
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme

@Composable
fun AppBarWithCloseAction(
    title: String?,
    onClosePressed: () -> Unit,
    actionItems: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            title?.let {
                Text(
                    text = it,
                    style = AppTheme.typography.h4,
                    color = AppColors.Greyscale00
                )
            }
        },
        backgroundColor = AppTheme.colors.surface,
        navigationIcon = {
            IconButton(onClick = { onClosePressed() }) {
                Icon(
                    imageVector = Rounded.Close,
                    contentDescription = "Close"
                )
            }
        },
        actions = actionItems
    )
}
