package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.nab.innovation.center.assignment.android.tungphan.common.ui.compose.theme.AppTheme
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.R
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListScreen
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.Companion.CITY_NAME_REGEX
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.Companion.DEFAULT_CITY_NAME

class WeatherForecastActivity : AppCompatActivity() {

    private val viewModel: WeatherListViewModel by viewModel { parametersOf(this) }

    private val screenTitleTxt: String by lazy {
        resources.getString(R.string.app_name)
    }

    private val celsiusDegreeTxt: String by lazy {
        resources.getString(R.string.celsius_degree)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {

                WeatherListScreen(
                    screenTitle = screenTitleTxt,
                    celsiusDegree = celsiusDegreeTxt,
                    validInputRegex = Regex(CITY_NAME_REGEX),
                    fetchThreeHoursStepWeatherData = { cityName ->
                        viewModel.fetchThreeHoursStepWeatherData(
                            cityName = cityName
                        )
                    },
                )
            }
        }

        loadDefaultCityWeatherData()
    }

    private fun loadDefaultCityWeatherData() {
        viewModel.fetchThreeHoursStepWeatherData(DEFAULT_CITY_NAME)
    }
}

