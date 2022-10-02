package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.R
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.common.ErrorSnackBar
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListState
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListScreenEvent

@Composable
fun WeatherListScreen(
    screenTitle: String,
    celsiusDegree: String,
    weatherListState: WeatherListState,
    weatherListScreenEvent: WeatherListScreenEvent?,
    fetchThreeHoursStepWeatherData: () -> Unit,
//    onItemSelected: (weatherItemUIModal: weatherItemUIModal) -> Unit
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
        topBar = {
            TopAppBar(
                title = { Text(
                    text= screenTitle,
                    color = AppTheme.colors.white
                ) },
                backgroundColor = AppTheme.colors.greyscale50
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = scaffoldState.snackbarHostState,
                snackbar = { snackBarData -> ErrorSnackBar(snackBarData) }
            )
        }
    ) {
        Column {

            TextField(
                value = cityNameText,
                placeholder = { Text("City Name") },
                onValueChange = {
                    cityNameText = it
                },
                label = { Text("Giving City Name Here, ex:\"Saigon\"") },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )

            Button(
                onClick = { fetchThreeHoursStepWeatherData },
                contentPadding = PaddingValues(
                    start = AppTheme.dimensions.THIRD_QUARTER_GRID_UNIT,
                    top = AppTheme.dimensions.HALF_GRID_UNIT,
                    end = AppTheme.dimensions.THIRD_QUARTER_GRID_UNIT,
                    bottom = AppTheme.dimensions.HALF_GRID_UNIT
                ),
                modifier = Modifier.wrapContentSize(),
                colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.greyscale50)
            ) {
                Text(
                    text="Get Weather Forecast",
                    color = AppTheme.colors.white
                )
            }

            WeatherListContent(
                celsiusDegree = celsiusDegree,
                weatherListState = weatherListState,
                coroutineScope = coroutineScope,
                scaffoldState = scaffoldState,
                somethingWentWrongText = somethingWentWrongText,
                retryText = retryText,
//            onItemSelected = onItemSelected,
                fetchThreeHoursStepWeatherData = fetchThreeHoursStepWeatherData
            )
        }
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
