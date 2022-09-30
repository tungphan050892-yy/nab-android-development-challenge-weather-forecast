package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities

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
    var clouds: Int? = null,
    var pop: Double? = null,
    var rain: Double? = null
)