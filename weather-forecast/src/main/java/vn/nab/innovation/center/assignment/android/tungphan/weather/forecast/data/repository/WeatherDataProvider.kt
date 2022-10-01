package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.WeatherLocalDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.WeatherRemoteDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.DEFAULT_DAILY_WEATHER
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.WeatherData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository.WeatherDataRepository

class WeatherDataProvider(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : WeatherDataRepository {

    private val allWeatherData = MutableStateFlow(DEFAULT_DAILY_WEATHER)

    override suspend fun getDailyWeatherData(
        location: String,
        cnt: String
    ): CallResult<WeatherData> = withContext(ioDispatcher) {
        val result = weatherRemoteDataSource.getDailyWeatherData(
            location = location,
            cnt = cnt
        )
        if (result.isSuccess) {
            result.getOrNull()?.let {
                this@WeatherDataProvider.allWeatherData.value = it
            }
        }
        result
    }

    override suspend fun getThreeHoursStepWeatherData(
        location: String
    ): CallResult<WeatherData> = withContext(ioDispatcher) {
        val result = weatherRemoteDataSource.getThreeHoursStepWeatherData(location)
        if (result.isSuccess) {
            result.getOrNull()?.let {
                this@WeatherDataProvider.allWeatherData.value = it
            }
        }
        result
    }
}
