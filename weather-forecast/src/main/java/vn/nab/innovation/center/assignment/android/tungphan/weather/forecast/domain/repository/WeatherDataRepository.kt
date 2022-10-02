package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData

interface WeatherDataRepository {

    suspend fun getDailyWeatherData(
        cityName: String,
        cnt: String
    ): CallResult<WeatherData>

    suspend fun getThreeHoursStepWeatherData(
        cityName: String
    ): CallResult<WeatherData>

}