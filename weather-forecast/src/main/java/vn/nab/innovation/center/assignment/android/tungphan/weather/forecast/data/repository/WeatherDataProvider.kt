package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.WeatherLocalDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.WeatherRemoteDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData.Companion.DEFAULT_WEATHER_DATA
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository.WeatherDataRepository

class WeatherDataProvider(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) : WeatherDataRepository {

    private val allWeatherData = MutableStateFlow(DEFAULT_WEATHER_DATA)

    override suspend fun getDailyWeatherData(
        cityName: String,
        cnt: String
    ): CallResult<WeatherData> {
        val result = weatherRemoteDataSource.getDailyWeatherData(
            cityName = cityName,
            cnt = cnt
        )
        if (result.isSuccess) {
            result.getOrNull()?.let {
                this@WeatherDataProvider.allWeatherData.value = it
            }
        }
        return result
    }

    override suspend fun getThreeHoursStepWeatherData(
        cityName: String
    ): CallResult<WeatherData> {
        val result = weatherRemoteDataSource.getThreeHoursStepWeatherData(cityName)
        if (result.isSuccess) {
            result.getOrNull()?.let {
                this@WeatherDataProvider.allWeatherData.value = it
            }
        }
        return result
    }
}
