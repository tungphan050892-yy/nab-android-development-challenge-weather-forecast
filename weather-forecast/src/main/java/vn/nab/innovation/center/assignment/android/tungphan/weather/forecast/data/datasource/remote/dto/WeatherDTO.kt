package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("main")
    @Expose
    val main: String? = null,
    @SerializedName("description")
    @Expose
    val description: String? = null,
    @SerializedName("icon")
    @Expose
    val icon: String? = null
)