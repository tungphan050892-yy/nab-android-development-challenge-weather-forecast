package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityDTO(
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("coord")
    @Expose
    var coord: CoordDTO? = null,
    @SerializedName("country")
    @Expose
    var country: String? = null,
    @SerializedName("population")
    @Expose
    var population: Int? = null,
    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null
)