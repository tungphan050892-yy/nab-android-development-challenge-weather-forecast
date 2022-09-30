package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Interface representing search local data source.
 */
interface WeatherLocalDataSource {
    /**
     * Returns [Flow] object containing [Weather] objects.
     */
    val weathers: Flow<Weather>

    /**
     * Sets provided search arguments inside the persistence solution.
     */
    suspend fun setSearchArguments(
        weather: Weather
    )
}

/**
 * Concrete implementation of [WeatherLocalDataSource] implemented using in memory persistence solution.
 * start with sharedpreference, TODO: migrate to room
 */
class WeatherLocalDataStoreImpl : WeatherLocalDataSource {

    private val _weathers: MutableStateFlow<Weather?> = MutableStateFlow(null)

    override val weathers: Flow<Weather> = _weathers

    override suspend fun setSearchArguments(
        weathers: Weather,
    ) {
        _weathers.value = weathers
    }
}
