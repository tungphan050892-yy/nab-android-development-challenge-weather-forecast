package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.WeatherLocalDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.WeatherRemoteDataSource

interface WeatherDataRepository {
    suspend fun getDailyWeatherData(): Result<List<Unit>>
}

class WeatherDataProvider(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : WeatherDataRepository {

    private val allWeatherData = MutableStateFlow<List<Unit>>(emptyList())

    override suspend fun getDailyWeatherData(): Result<List<Unit>> = withContext(ioDispatcher) {
        val result = weatherRemoteDataSource.getDailyWeatherData()

        if (result.isSuccess) {
            val allWeatherData = result.getOrNull() ?: emptyList()
            this@WeatherDataProvider.allWeatherData.value = allWeatherData
        }

        result
    }
}
