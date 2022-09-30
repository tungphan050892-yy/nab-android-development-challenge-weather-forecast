package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityDTO(
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("coord")
    @Expose
    val coord: CoordDTO? = null,
    @SerializedName("country")
    @Expose
    val country: String? = null,
    @SerializedName("population")
    @Expose
    val population: Int? = null,
    @SerializedName("timezone")
    @Expose
    val timezone: Int? = null
)