package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData

/**
 * Interface representing search local data source.
 */
interface WeatherLocalDataSource {
    /**
     * Returns [Flow] object containing [] objects.
     */
    val weatherData: Flow<WeatherData?>

    /**
     * Sets provided search arguments inside the persistence solution.
     */
    suspend fun setSearchArguments(weatherData: WeatherData)
}

/**
 * Concrete implementation of [WeatherLocalDataSource] implemented using in memory persistence solution.
 * start with sharedpreference, TODO: migrate to room
 */
class WeatherLocalDataStoreImpl : WeatherLocalDataSource {

    private val _weatherData: MutableStateFlow<WeatherData?> = MutableStateFlow(null)

    override val weatherData: Flow<WeatherData?> = _weatherData

    override suspend fun setSearchArguments(weatherData: WeatherData) {
        _weatherData.value = weatherData
    }
}
