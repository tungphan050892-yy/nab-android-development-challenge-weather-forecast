package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WeatherDataDTO

interface OpenWeatherMapAPI {

    //region get daily weather data
    @GET("/forecast/daily?q={location}&cnt={cnt}")
    suspend fun getDailyWeatherData(
        @Path("location") location: String,
        @Path("cnt") cnt: String
    ): Response<WeatherDataDTO>
    //endregion

    // region get three hours step weather data
    @GET("/forecast?q={location}")
    suspend fun getThreeHoursStepWeatherData(
        @Path("location") location: String
    ): Response<WeatherDataDTO>
    //endregion
}