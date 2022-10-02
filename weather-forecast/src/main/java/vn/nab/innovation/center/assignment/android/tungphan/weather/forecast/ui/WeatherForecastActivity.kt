package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.R
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListScreen
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.Companion.DEFAULT_CITY_NAME
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListState
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListScreenEvent

class WeatherForecastActivity : AppCompatActivity() {

    private val viewModel: WeatherListViewModel by viewModel { parametersOf(this) }

    private val screenTitle: String by lazy {
        resources.getString(R.string.app_name)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val weatherListState: WeatherListState by viewModel.weatherDataState.observeAsState(
                    WeatherListState.Loading()
                )
                val weatherListScreenEvent: WeatherListScreenEvent? by viewModel.screenEvent.observeAsState()

                WeatherListScreen(
                    screenTitle = screenTitle,
                    weatherListState = weatherListState,
                    weatherListScreenEvent = weatherListScreenEvent,
                    fetchThreeHoursStepWeatherData = {
                        viewModel.fetchThreeHoursStepWeatherData(
                            location = DEFAULT_CITY_NAME
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
        loadDefaultCityWeatherData()
    }

    private fun loadDefaultCityWeatherData() {
        viewModel.fetchThreeHoursStepWeatherData(DEFAULT_CITY_NAME)
    }
}

