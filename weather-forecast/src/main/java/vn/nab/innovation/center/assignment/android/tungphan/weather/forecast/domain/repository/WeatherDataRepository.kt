package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.WeatherData

interface WeatherDataRepository {

    suspend fun getDailyWeatherData(
        location: String,
        cnt: String
    ): CallResult<WeatherData>

    suspend fun getThreeHoursStepWeatherData(
        location: String
    ): CallResult<WeatherData>

}