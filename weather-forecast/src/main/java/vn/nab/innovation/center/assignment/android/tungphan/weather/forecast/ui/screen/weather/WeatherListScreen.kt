package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.widgets.LoadingScreen
import vn.nab.innovation.center.assignment.android.tungphan.core.viewmodel.state.ViewModelState
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.R
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.common.ErrorContent
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.common.ErrorSnackBar
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model.WeatherItemUiModal
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListState
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListScreenEvent

@Composable
fun WeatherListScreen(
    weatherListState: WeatherListState,
    weatherListScreenEvent: WeatherListScreenEvent?,
    fetchThreeHoursStepWeatherData: () -> Unit,
//    onItemSelected: (weatherItemUIModal: weatherItemUIModal) -> Unit,
//    onDeleteClicked: (weatherItemUIModal: weatherItemUIModal) -> Unit
) {
    // Common resources.
    val somethingWentWrongText = stringResource(R.string.something_went_wrong)
    val retryText = stringResource(R.string.retry)

    // Single snack bar host state which handles displaying of error snack bar.
    val snackBarHostState = remember { SnackbarHostState() }
    val scaffoldState = rememberScaffoldState(snackbarHostState = snackBarHostState)
    val coroutineScope = rememberCoroutineScope()
    var cityNameText by remember { mutableStateOf("") }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = scaffoldState.snackbarHostState,
                snackbar = { snackBarData -> ErrorSnackBar(snackBarData) }
            )
        }
    ) {
        TextField(
            value = "",
            onValueChange = {
                cityNameText = it
            },
            label = { Text("Giving City Name Here, ex:\"Saigon\"") }
        )

        Button(
            onClick = { /* ... */ },
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = AppTheme.dimensions.HALF_GRID_UNIT,
                top = AppTheme.dimensions.HALF_GRID_UNIT,
                end = AppTheme.dimensions.HALF_GRID_UNIT,
                bottom = AppTheme.dimensions.HALF_GRID_UNIT
            )
        ) {
            Text("Get Weather Forecast")
        }

        WeatherListContent(
            weatherListState = weatherListState,
            coroutineScope = coroutineScope,
            scaffoldState = scaffoldState,
            somethingWentWrongText = somethingWentWrongText,
            retryText = retryText,
//            onItemSelected = onItemSelected,
//            onDeleteClicked = onDeleteClicked,
            fetchThreeHoursStepWeatherData = fetchThreeHoursStepWeatherData
        )
    }

    // Handle events.
    weatherListScreenEvent?.let { event ->
        when (event) {
            is WeatherListScreenEvent.ShowError -> {
                coroutineScope.launch {
                    val snackBarResult = snackBarHostState.showSnackbar(
                        message = somethingWentWrongText,
                        actionLabel = retryText,
                        duration = SnackbarDuration.Indefinite
                    )
                    when (snackBarResult) {
                        SnackbarResult.Dismissed -> Unit // Do nothing.
                        SnackbarResult.ActionPerformed -> Unit // Do nothing
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherListContent(
    weatherListState: ViewModelState,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    somethingWentWrongText: String,
    retryText: String,
//    onItemSelected: (weatherItemUIModal: weatherItemUIModal) -> Unit,
//    onDeleteClicked: (weatherItemUIModal: weatherItemUIModal) -> Unit,
    fetchThreeHoursStepWeatherData: () -> Unit
) {
    Surface {
        when (weatherListState) {
            is WeatherListState.Loading -> LoadingScreen()
            is WeatherListState.Loaded -> {
                WeatherForecastList(
                    weatherListState.weatherItemUiModal ?: emptyList(),
//                    onItemSelected,
//                    onDeleteClicked
                )
            }
            is WeatherListState.Empty -> {
                WeatherForecastEmptyScreen()
            }
            is WeatherListState.ErrorOccur -> {
                ErrorContent()
                with(coroutineScope) {
                    launch {
                        val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                            message = somethingWentWrongText,
                            actionLabel = retryText,
                            duration = SnackbarDuration.Indefinite
                        )
                        when (snackBarResult) {
                            SnackbarResult.Dismissed -> Unit // Do nothing.
                            SnackbarResult.ActionPerformed -> fetchThreeHoursStepWeatherData()
                        }
                    }
                }
            }
            else -> {
                // log it
            }
        }
    }
}

@Composable
private fun WeatherForecastList(
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
            renderItem(item)
        }
    }
}

private fun LazyListScope.renderItem(weatherItemUiModal: WeatherItemUiModal) {
    items(weatherItemUiModal.dateString.toInt()) { _ ->
        WeatherItemRow(weatherItemUiModal = weatherItemUiModal)
    }
}

@Composable
private fun WeatherItemRow(
    weatherItemUiModal: WeatherItemUiModal
//    onItemSelected: (weatherItemUIModal: weatherItemUIModal) -> Unit,
//    onDeleteClicked: (weatherItemUIModal: weatherItemUIModal) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(top = AppTheme.dimensions.ONE_GRID_UNIT)
            .background(color = AppTheme.colors.white),
//            .clickable { onItemSelected(weatherItemUiModel) },
    ) {
        WeatherItemText("Date: ${weatherItemUiModal.dateString}")
        WeatherItemText("Average Temperature: ${weatherItemUiModal.averageTemperature}")
        WeatherItemText("Pressure: ${weatherItemUiModal.pressure}")
        WeatherItemText("Humidity: ${weatherItemUiModal.humidity}")
        WeatherItemText("Description: ${weatherItemUiModal.description}")
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
            color = AppTheme.colors.white
        )
    )
}

@Composable
private fun WeatherForecastEmptyScreen() {
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
