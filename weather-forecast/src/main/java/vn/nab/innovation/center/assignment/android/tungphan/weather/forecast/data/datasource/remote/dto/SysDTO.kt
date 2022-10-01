package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SysDTO(
    @SerializedName("pod")
    @Expose
    var pod: String? = null
)