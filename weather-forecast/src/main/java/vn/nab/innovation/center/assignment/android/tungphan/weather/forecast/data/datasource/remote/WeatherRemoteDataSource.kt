package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.Weather

interface WeatherRemoteDataSource {

    suspend fun getDailyWeatherData(): Result<List<Weather>>

}