package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.repository

import com.google.gson.Gson
import vn.nab.innovation.center.assignment.android.tungphan.core.logging.createLogger
import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.WeatherLocalDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.WeatherRemoteDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest.NoInternet
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.LocalResponseTimeData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.LocalWeatherData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData.Companion.DEFAULT_WEATHER_DATA
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository.WeatherDataRepository

class WeatherDataProvider(
    private val weatherLocalDataSource: WeatherLocalDataSource,
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val gson: Gson
) : WeatherDataRepository {

    companion object {
        const val THREE_HOURS_IN_MILLISECONDS = 10800000
    }

    //TODO: investigate why logger is not yet working (org.slf4j config)
    private val logger = createLogger()

    override suspend fun getDailyWeatherData(
        cityName: String,
        cnt: String
    ): CallResult<WeatherData> {
        val result = weatherRemoteDataSource.getDailyWeatherData(
            cityName = cityName,
            cnt = cnt
        )
        if (result.isSuccess) {
            //temporary doing nothing
        }
        return result
    }

    /**
     * Lets ASSUME that the MVP caching mechanism will be:
     * - get three hours step weather data won't be change in 3 hours for a city compare to the last response time (in milliseconds)
     * - If still in 3 hours, get local data instead to reduce over throttle API calls
     * - If there is no network, local data exists, get it
     * - the complexity of caching will base on requirement needed, also consider to fetch local data and display before
     * data get loaded remotely for better user experience.
     */
    override suspend fun getThreeHoursStepWeatherData(
        cityName: String
    ): CallResult<WeatherData> {
        val shouldRequest = shouldTakeNewRequest(cityName)

        //TODO: optimize this if-else hell if having time
        if (shouldRequest) {
            val result = weatherRemoteDataSource.getThreeHoursStepWeatherData(cityName)
            return if (result.isSuccess) {//success -> return result
                result.getOrNull()?.let { weatherData ->
                    logger.error("request weather data successfully, store it locally")
                    storeThreeHoursStepWeatherDataLocally(cityName, weatherData)
                    storeLastGetThreeHoursWeatherDataResponseTime(cityName, System.currentTimeMillis())
                }
                result
            } else {//if not success, consider to load data locally
                if (result.exceptionOrNull() == NoInternet) {
                    logger.error("no internet, get data locally")
                    val data = getThreeHoursStepWeatherDataLocally(cityName)
                    CallResult.success(data)
                } else {
                    logger.error("request failed with exception")
                    result
                }
            }
        } else {
            logger.error("still in 3 hours, get cache data")
            val data = getThreeHoursStepWeatherDataLocally(cityName)
            return CallResult.success(data)
        }
    }

    private fun storeLastGetThreeHoursWeatherDataResponseTime(cityName: String, responseTime: Long) {
        val existingLocalData = weatherLocalDataSource.lastGetThreeHoursWeatherDataResponseTime
        val newLocalData = if (existingLocalData.isNotBlank()) {
            val localWeatherData: LocalResponseTimeData = gson.fromJson(existingLocalData, LocalResponseTimeData::class.java)
            val mutableMap = localWeatherData.responseTime?.toMutableMap() ?: mutableMapOf()

            mutableMap[cityName] = responseTime
            LocalResponseTimeData(
                responseTime = mutableMap
            )
        } else {
            LocalResponseTimeData(
                responseTime = mapOf(cityName to responseTime)
            )
        }
        weatherLocalDataSource.lastGetThreeHoursWeatherDataResponseTime = gson.toJson(newLocalData)
    }

    /**
     * TODO: consider return nullable in case there's no existing weather data for the city in local storage
     * because handling nullable case won't affect what user see on the ui if the WeatherData modal structure changed
     */
    private fun getThreeHoursStepWeatherDataLocally(cityName: String): WeatherData {
        val localData = weatherLocalDataSource.threeHoursStepWeatherData
        return if (localData.isNotBlank()) {
            val localWeatherData: LocalWeatherData = gson.fromJson(localData, LocalWeatherData::class.java)
            if (localWeatherData.weatherDataMap.isNullOrEmpty()) {
                DEFAULT_WEATHER_DATA
            } else {
                localWeatherData.weatherDataMap[cityName] ?: DEFAULT_WEATHER_DATA
            }
        } else DEFAULT_WEATHER_DATA
    }

    //temporary make it as fire and forget
    private fun storeThreeHoursStepWeatherDataLocally(cityName: String, weatherData: WeatherData) {
        val existingLocalData = weatherLocalDataSource.threeHoursStepWeatherData
        val newLocalData = if (existingLocalData.isNotBlank()) {
            val localWeatherData: LocalWeatherData = gson.fromJson(existingLocalData, LocalWeatherData::class.java)
            val mutableMap = localWeatherData.weatherDataMap?.toMutableMap() ?: mutableMapOf()

            mutableMap[cityName] = weatherData
            LocalWeatherData(
                weatherDataMap = mutableMap
            )
        } else {
            LocalWeatherData(
                weatherDataMap = mapOf(cityName to weatherData)
            )
        }
        weatherLocalDataSource.threeHoursStepWeatherData = gson.toJson(newLocalData)
    }

    private fun shouldTakeNewRequest(cityName: String): Boolean {
        val localResponseTime = weatherLocalDataSource.lastGetThreeHoursWeatherDataResponseTime
        val currentTimestamp = System.currentTimeMillis()

        val lastResponseTime = if (localResponseTime.isNotBlank()) {
            val localResponseTimeData: LocalResponseTimeData = gson.fromJson(localResponseTime, LocalResponseTimeData::class.java)
            if (localResponseTimeData.responseTime.isNullOrEmpty()) {
                0
            } else {
                localResponseTimeData.responseTime[cityName] ?: 0
            }
        } else 0

        return currentTimestamp - lastResponseTime >= THREE_HOURS_IN_MILLISECONDS
    }
}
