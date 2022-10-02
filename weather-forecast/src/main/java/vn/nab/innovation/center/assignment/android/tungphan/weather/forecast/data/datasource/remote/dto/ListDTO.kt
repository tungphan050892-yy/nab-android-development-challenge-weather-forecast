package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//These todo is for the DTO package, not just this data class
//TODO: consider to short out only the data which need for the app to process instead of mapping all the json data return
//TODO: consider of using var or val
//TODO: consider of cover nullable or not
data class ListDTO(
    @SerializedName("dt")
    @Expose
    val dt: Int? = null,
    @SerializedName("sunrise")
    @Expose
    val sunrise: Int? = null,
    @SerializedName("sunset")
    @Expose
    val sunset: Int? = null,
    @SerializedName("temp")
    @Expose
    val temp: TempDTO? = null,
    @SerializedName("feels_like")
    @Expose
    val feelsLike: FeelsLikeDTO? = null,
    @SerializedName("pressure")
    @Expose
    val pressure: Int? = null,
    @SerializedName("humidity")
    @Expose
    val humidity: Int? = null,
    @SerializedName("weather")
    @Expose
    val weather: List<WeatherDTO>? = null,
    @SerializedName("speed")
    @Expose
    val speed: Double? = null,
    @SerializedName("deg")
    @Expose
    val deg: Int? = null,
    @SerializedName("gust")
    @Expose
    val gust: Double? = null,
    @SerializedName("clouds")
    @Expose
    val clouds: CloudDTO? = null,
    @SerializedName("pop")
    @Expose
    val pop: Double? = null,
    @SerializedName("rain")
    @Expose
    val rain: RainDTO? = null,
    @SerializedName("main")
    @Expose
    val main: MainDTO? = null,
    @SerializedName("visibility")
    @Expose
    val visibility: Int? = null,
    @SerializedName("sys")
    @Expose
    val sys: SysDTO? = null,
    @SerializedName("dt_txt")
    @Expose
    val dtTxt: String? = null,
    @SerializedName("wind")
    @Expose
    val wind: WindDTO? = null
)