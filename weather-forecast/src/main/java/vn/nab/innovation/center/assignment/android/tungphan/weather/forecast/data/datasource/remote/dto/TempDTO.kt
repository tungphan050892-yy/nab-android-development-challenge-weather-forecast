package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//TODO: maybe temperature?
data class TempDTO(
    @SerializedName("day")
    @Expose
    val day: Double? = null,
    @SerializedName("min")
    @Expose
    val min: Double? = null,
    @SerializedName("max")
    @Expose
    val max: Double? = null,
    @SerializedName("night")
    @Expose
    val night: Double? = null,
    @SerializedName("eve")
    @Expose
    val eve: Double? = null,
    @SerializedName("morn")
    @Expose
    val morn: Double? = null
)