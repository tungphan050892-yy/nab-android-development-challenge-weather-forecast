package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoordDTO(
    @SerializedName("lon")
    @Expose
    val lon: Double? = null,
    @SerializedName("lat")
    @Expose
    val lat: Double? = null
)