package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class FeelsLikeDTO(
    @SerializedName("day")
    @Expose
    var day: Double? = null,
    @SerializedName("night")
    @Expose
    var night: Double? = null,
    @SerializedName("eve")
    @Expose
    var eve: Double? = null,
    @SerializedName("morn")
    @Expose
    var morn: Double? = null
)