package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper.toEntityObject
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.ConnectionChecker
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.WeatherMapAPI
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData

/**
 * [NetworkRequest] responsible to get daily weather data from one weather map API
 */
class GetDailyWeatherDataNetworkRequest(
    private val connectionChecker: ConnectionChecker,
    private val weatherMapApi: WeatherMapAPI
) : NetworkRequest<WeatherData, GetDailyWeatherDataParams> by simpleNetworkRequest(
    connectionChecker = connectionChecker,
    lambdaCall = { params ->
        val response = weatherMapApi.getDailyWeatherData(
            cityName = params.cityName,
            cnt = params.cnt
        )

        return@simpleNetworkRequest if (response.isSuccessful && response.body() != null) {
            CallResult.success(response.body()!!.toEntityObject())
        } else {
            val errors = response.message()
            CallResult.failure(Throwable(errors))
        }
    }
)

data class GetDailyWeatherDataParams(
    val cityName: String,
    val cnt: String
)
