package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDataDTO(
    @SerializedName("cod")
    @Expose
    val cod: String? = null,
    @SerializedName("message")
    @Expose
    val message: Int? = null,
    @SerializedName("cnt")
    @Expose
    val cnt: Int? = null,
    @SerializedName("list")
    @Expose
    val listDTO: List<ListDTO>? = null,
    @SerializedName("city")
    @Expose
    val city: CityDTO? = null
)