package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WeatherDataDTO

/**
 * Interface to use with Retrofit2 and calling API from OneWeatherMap.org
 */
interface WeatherMapAPI {

    //region get daily weather data
    //this API is not usable for free user
    @GET("forecast/daily?q={location}&cnt={cnt}")
    suspend fun getDailyWeatherData(
        @Path("location") location: String,
        @Path("cnt") cnt: String
    ): Response<WeatherDataDTO>
    //endregion

    // region get three hours step weather data
    @GET("forecast?q={location}")
    suspend fun getThreeHoursStepWeatherData(
        @Path("location") location: String
    ): Response<WeatherDataDTO>
    //endregion

}