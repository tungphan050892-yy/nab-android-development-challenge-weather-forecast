package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest.GetDailyWeatherDataParams
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest.GetThreeHoursStepWeatherDataParams
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest.NetworkRequest
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData

class WeatherRemoteDataSourceImpl(
    private val getDailyWeatherDataNetworkRequest: NetworkRequest<WeatherData, GetDailyWeatherDataParams>,
    private val getThreeHoursStepWeatherDataNetworkRequest: NetworkRequest<WeatherData, GetThreeHoursStepWeatherDataParams>,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : WeatherRemoteDataSource {

    override suspend fun getDailyWeatherData(cityName: String, cnt: String): CallResult<WeatherData> = withContext(ioDispatcher) {
        val params = GetDailyWeatherDataParams(cityName = cityName, cnt = cnt)
        getDailyWeatherDataNetworkRequest.execute(params)
    }

    override suspend fun getThreeHoursStepWeatherData(cityName: String): CallResult<WeatherData> = withContext(ioDispatcher) {
        val params = GetThreeHoursStepWeatherDataParams(cityName = cityName)
        getThreeHoursStepWeatherDataNetworkRequest.execute(params)
    }
}