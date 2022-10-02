package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.widgets.LoadingScreen
import vn.nab.innovation.center.assignment.android.tungphan.core.viewmodel.state.ViewModelState
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.common.ErrorContent


@Composable
fun WeatherListContent(
    celsiusDegree: String,
    weatherListState: ViewModelState,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    somethingWentWrongText: String,
    retryText: String,
//    onItemSelected: (weatherItemUIModal: weatherItemUIModal) -> Unit,
    fetchThreeHoursStepWeatherData: () -> Unit
) {
    Surface {
        when (weatherListState) {
            is WeatherListViewModel.WeatherListState.Loading -> LoadingScreen()
            is WeatherListViewModel.WeatherListState.Loaded -> {
                WeatherForecastList(
                    celsiusDegree,
                    weatherListState.weatherItemUiModal ?: emptyList(),
//                    onItemSelected
                )
            }
            is WeatherListViewModel.WeatherListState.Empty -> {
                WeatherForecastEmptyScreen()
            }
            is WeatherListViewModel.WeatherListState.ErrorOccur -> {
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