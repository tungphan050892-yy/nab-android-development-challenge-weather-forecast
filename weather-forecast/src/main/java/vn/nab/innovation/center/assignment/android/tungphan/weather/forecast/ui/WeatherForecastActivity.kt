package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListScreen
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListState
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListScreenEvent

class WeatherForecastActivity : AppCompatActivity() {

    private val viewModel: WeatherListViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val weatherListState: WeatherListState by viewModel.weatherDataState.observeAsState(
                    WeatherListState.Loading()
                )
                val weatherListScreenEvent: WeatherListScreenEvent? by viewModel.screenEvent.observeAsState()

                WeatherListScreen(
                    weatherListState = weatherListState,
                    weatherListScreenEvent = weatherListScreenEvent,
                    fetchThreeHoursStepWeatherData = {
                        viewModel.fetchThreeHoursStepWeatherData(
                            location = "Saigon"
                        )
                    },
//                    onItemSelected = { weatherItemUIModal ->
//                        openWeatherItem(weatherItemUIModal)
//                    },
//                    onDeleteClicked = { weatherItemUIModal ->
//                        displayConfirmDeleteDialog(weatherItemUIModal)
//                    }
                )
            }
        }
    }
}

