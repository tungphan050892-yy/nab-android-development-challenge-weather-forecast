package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

internal class PreferencesProvider(context: Context) : Preferences {
    private val preferences = context.getSharedPreferences(NAB_WEATHER_FORECAST_SHARED_PREFS_NAME, MODE_PRIVATE)


    override var lastGetThreeHoursWeatherDataResponseTime: String
        get() = preferences.getString(KEY_LAST_THREE_HOURS_STEP_WEATHER_DATA_RESPONSE_TIME, "") ?: ""
        set(value) {
            preferences.edit { putString(KEY_LAST_THREE_HOURS_STEP_WEATHER_DATA_RESPONSE_TIME, value) }
        }

    override var threeHoursStepWeatherData: String
        get() = preferences.getString(KEY_THREE_HOURS_STEP_WEATHER_DATA, "") ?: ""
        set(value) {
            preferences.edit { putString(KEY_THREE_HOURS_STEP_WEATHER_DATA, value) }
        }

    companion object {
        private const val NAB_WEATHER_FORECAST_SHARED_PREFS_NAME = "nab_weather_forecast_shared_prefs_name"
        private const val KEY_LAST_THREE_HOURS_STEP_WEATHER_DATA_RESPONSE_TIME = "key_last_three_hours_step_weather_data_response_time"
        private const val KEY_THREE_HOURS_STEP_WEATHER_DATA = "key_three_hours_step_weather_data"
    }
}
