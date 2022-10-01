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

    override suspend fun getDailyWeatherData(location: String, cnt: String): CallResult<WeatherData> = withContext(ioDispatcher) {
        val params = GetDailyWeatherDataParams(location = location, cnt = cnt)
        getDailyWeatherDataNetworkRequest.execute(params)
    }

    override suspend fun getThreeHoursStepWeatherData(location: String): CallResult<WeatherData> = withContext(ioDispatcher) {
        val params = GetThreeHoursStepWeatherDataParams(location = location)
        getThreeHoursStepWeatherDataNetworkRequest.execute(params)
    }
}