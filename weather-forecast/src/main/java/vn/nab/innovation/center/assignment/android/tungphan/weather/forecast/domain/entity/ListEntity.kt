package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

//Naming like this so it will not be duplicate with kotlin.collection type: List
data class ListEntity(
    var dt: Int? = null,
    var sunrise: Int? = null,
    var sunset: Int? = null,
    var temp: Temperature? = null,
    var feelsLike: FeelsLike? = null,
    var pressure: Int? = null,
    var humidity: Int? = null,
    var weather: List<Weather>? = null,
    var speed: Double? = null,
    var deg: Int? = null,
    var gust: Double? = null,
    var clouds: Cloud? = null,
    var pop: Double? = null,
    var rain: Rain? = null,
    var main: Main? = null,
    var visibility: Int? = null,
    var sys: Sys? = null,
    var dtTxt: String? = null,
    var wind: Wind? = null
) {
    companion object {
        val DEFAULT_LIST_ITEM = ListEntity(
            dt = 0,
            sunrise = 0,
            sunset = 0,
            temp = null,
            feelsLike = null,
            pressure = 0,
            humidity = 0,
            weather = emptyList(),
            speed = 0.0,
            deg = 0,
            gust = 0.0,
            clouds = null,
            pop = 0.0,
            rain = null,
            main = null,
            visibility = 0,
            sys = null,
            dtTxt = "",
            wind = null
        )
    }
}