package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.Weather

interface WeatherDataRepository {

    suspend fun getDailyWeatherData(): Result<List<Weather>>

}