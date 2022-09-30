package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyWeatherResponseDTO(
    @SerializedName("city")
    @Expose
    val city: CityDTO? = null,
    @SerializedName("cod")
    @Expose
    val cod: String? = null,
    @SerializedName("message")
    @Expose
    val message: Double? = null,
    @SerializedName("cnt")
    @Expose
    val cnt: Int? = null,
    @SerializedName("list")
    @Expose
    val list: List<ListDTO>? = null
)