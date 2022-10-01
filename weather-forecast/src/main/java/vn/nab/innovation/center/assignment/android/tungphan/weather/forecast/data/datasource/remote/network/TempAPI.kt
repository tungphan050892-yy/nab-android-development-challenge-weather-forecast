package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/*
* As scope of this assignment, I use https://openweathermap.org/ as 3rd party provide data & API
* For the API key, I registered it with freemium account
*/
interface OpenWeatherMapApi {

    //region get daily fore cast
    @GET("/forecast/daily?q={location}&cnt={cnt}")
    suspend fun getDailyForecast(
        @Path("location") location: String,
        @Path("cnt") cnt: String
    ): Response<DailyWeatherResponseDTO>
    //endregion
}
