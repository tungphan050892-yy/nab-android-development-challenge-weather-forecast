package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model.WeatherItemUiModal

@Composable
fun WeatherForecastList(
    weatherUIItems: List<WeatherItemUiModal>
) {
    val itemsToDisplay: Map<String, WeatherItemUiModal> = weatherUIItems.associateBy {
        it.dateString
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.greyscale95)
    ) {
        itemsToDisplay.forEach { (_, item) ->
            renderItem(weatherItemUiModal = item)
        }
    }
}

private fun LazyListScope.renderItem(weatherItemUiModal: WeatherItemUiModal) {
    item(
        key = weatherItemUiModal.dateString.toInt(),
        content = {
            WeatherItemRow(weatherItemUiModal = weatherItemUiModal)
            Divider(thickness = AppTheme.dimensions.HALF_QUARTER_GRID_UNIT)
        }
    )
}

@Composable
private fun WeatherItemRow(
    weatherItemUiModal: WeatherItemUiModal
//    onItemSelected: (weatherItemUIModal: weatherItemUIModal) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = AppTheme.colors.white),
//            .clickable { onItemSelected(weatherItemUiModel) },
    ) {
        Column {
            WeatherItemText("Date: ${weatherItemUiModal.dateString}")
            WeatherItemText("Average Temperature: ${weatherItemUiModal.averageTemperature}")
            WeatherItemText("Pressure: ${weatherItemUiModal.pressure}")
            WeatherItemText("Humidity: ${weatherItemUiModal.humidity}")
            WeatherItemText("Description: ${weatherItemUiModal.description}")
        }
    }
}

@Composable
private fun WeatherItemText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .wrapContentWidth()
            .padding(
                start = AppTheme.dimensions.ONE_AND_HALF_GRID_UNIT,
                end = AppTheme.dimensions.ONE_AND_HALF_GRID_UNIT
            )
            .defaultMinSize(
                AppTheme.dimensions.THREE_GRID_UNIT,
                AppTheme.dimensions.THREE_GRID_UNIT
            )
            .height(AppTheme.dimensions.THREE_GRID_UNIT),
        textAlign = TextAlign.Center,
        style = AppTheme.typography.body2.copy(
            color = AppTheme.colors.black
        )
    )
}