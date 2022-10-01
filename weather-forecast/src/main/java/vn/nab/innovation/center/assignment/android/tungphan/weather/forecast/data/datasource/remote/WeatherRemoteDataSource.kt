package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData

interface WeatherRemoteDataSource {

    suspend fun getDailyWeatherData(location: String, cnt: String): CallResult<WeatherData>

    suspend fun getThreeHoursStepWeatherData(location: String): CallResult<WeatherData>

}