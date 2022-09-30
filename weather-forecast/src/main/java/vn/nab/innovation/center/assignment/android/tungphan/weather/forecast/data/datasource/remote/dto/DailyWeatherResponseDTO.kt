package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyWeatherResponseDTO(
    @SerializedName("city")
    @Expose
    var city: CityDTO? = null,
    @SerializedName("cod")
    @Expose
    var cod: String? = null,
    @SerializedName("message")
    @Expose
    var message: Double? = null,
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null,
    @SerializedName("list")
    @Expose
    var list: List<ListDTO>? = null
)