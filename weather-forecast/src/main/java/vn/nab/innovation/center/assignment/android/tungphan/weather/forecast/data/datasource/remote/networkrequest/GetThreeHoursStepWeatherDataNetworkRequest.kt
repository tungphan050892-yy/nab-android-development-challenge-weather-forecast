package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper.toEntityObject
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.ConnectionChecker
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.WeatherMapAPI
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData
import javax.net.ssl.HttpsURLConnection

class GetThreeHoursStepWeatherDataNetworkRequest(
    private val connectionChecker: ConnectionChecker,
    private val weatherMapApi: WeatherMapAPI
) : NetworkRequest<WeatherData, GetThreeHoursStepWeatherDataParams> by simpleNetworkRequest(
    connectionChecker = connectionChecker,
    lambdaCall = { params ->
        val response = weatherMapApi.getThreeHoursStepWeatherData(
            location = params.location
        )

        return@simpleNetworkRequest if (response.isSuccessful && response.body() != null) {
            CallResult.success(response.body()!!.toEntityObject())
        } else {
            when (response.code()) {
                HttpsURLConnection.HTTP_NOT_FOUND -> {
                    CallResult.failure(Throwable("City Name Not Found"))
                }
                else -> {
                    val errors = response.message()
                    CallResult.failure(Throwable(errors))
                }
            }
        }
    }
)

data class GetThreeHoursStepWeatherDataParams(
    val location: String
)