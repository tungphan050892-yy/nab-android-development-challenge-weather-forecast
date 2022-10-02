package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.R

@Composable
fun WeatherForecastEmptyScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(AppTheme.dimensions.TWO_GRID_UNIT)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimensions.FOUR_GRID_UNIT)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_sad),
                contentDescription = null,
                colorFilter = ColorFilter.tint(AppTheme.colors.greyscale80),
                modifier = Modifier
                    .size(AppTheme.dimensions.SIXTEEN_GRID_UNIT)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = AppTheme.dimensions.TWO_GRID_UNIT)
                    .background(color = Color.White),
            )

            Text(
                text = stringResource(id = R.string.weather_list_empty_title),
                modifier = Modifier
                    .widthIn(max = AppTheme.dimensions.THIRTY_SEVEN_GRID_UNIT)
                    .wrapContentHeight()
                    .padding(
                        bottom = AppTheme.dimensions.TWO_GRID_UNIT
                    )
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.h6.copy(
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.greyscale40
                )
            )

            Text(
                text = stringResource(id = R.string.weather_list_empty_description),
                modifier = Modifier
                    .widthIn(max = AppTheme.dimensions.THIRTY_SEVEN_GRID_UNIT)
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Normal,
                    color = AppTheme.colors.greyscale40
                )
            )
        }
    }
}