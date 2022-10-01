package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network

import retrofit2.Response
import retrofit2.http.*
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WeatherDataDTO

/*
* As scope of this assignment, I use https://openweathermap.org/ as 3rd party provide data & API
* For the API key, I registered it with freemium account
*/
interface OpenWeatherMapApi {

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
