package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.R

@Composable
fun ErrorContent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.surface)
    ) {
        Icon(
            modifier = Modifier.size(100.dp, 100.dp),
            painter = painterResource(id = R.drawable.ic_sad), contentDescription = "Sad",
            tint = AppTheme.colors.greyscale90
        )
    }
}
