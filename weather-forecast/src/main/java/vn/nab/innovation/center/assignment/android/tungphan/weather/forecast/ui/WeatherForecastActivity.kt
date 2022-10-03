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

/**
 * TODO: to optimize the experience for people with disability (eyes, touch, blind, color blind, etc)
 * its all about a whole concept related to the topic and need a whole team to work on it from the feature design,
 * ui/ux, to the point a developer understand the support from the platform (which is Android in this case)
 *
 * - In this assignment, I just trying to do my best, the button might be a bit smaller to the actual needed for disabillity people
 * or the content description, button clickLabel is not fully enable so that Talkback in Android will work probably
 * - Some basics principle for accessbility in android described here: https://material.io/design/usability/accessibility.html
 * - Personal advice: not place a button where the talkback accessibility button is, normally it place near floating button position on the
 * bottom right
 *
 * Forgive me if anything is missing, it's my cat fault!
 */
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

