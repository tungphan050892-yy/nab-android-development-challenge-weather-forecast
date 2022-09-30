package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.Weather

//These todo is for the DTO package, not just this data class
//TODO: consider to short out only the data which need for the app to process instead of mapping all the json data return
//TODO: consider of using var or val
//TODO: consider of cover nullable or not
data class ListDTO(
    @SerializedName("dt")
    @Expose
    var dt: Int? = null,
    @SerializedName("sunrise")
    @Expose
    var sunrise: Int? = null,
    @SerializedName("sunset")
    @Expose
    var sunset: Int? = null,
    @SerializedName("temp")
    @Expose
    var temp: TempDTO? = null,
    @SerializedName("feels_like")
    @Expose
    var feelsLike: FeelsLikeDTO? = null,
    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null,
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null,
    @SerializedName("weather")
    @Expose
    var weather: List<WeatherDTO>? = null,
    @SerializedName("speed")
    @Expose
    var speed: Double? = null,
    @SerializedName("deg")
    @Expose
    var deg: Int? = null,
    @SerializedName("gust")
    @Expose
    var gust: Double? = null,
    @SerializedName("clouds")
    @Expose
    var clouds: Int? = null,
    @SerializedName("pop")
    @Expose
    var pop: Double? = null,
    @SerializedName("rain")
    @Expose
    var rain: Double? = null
)