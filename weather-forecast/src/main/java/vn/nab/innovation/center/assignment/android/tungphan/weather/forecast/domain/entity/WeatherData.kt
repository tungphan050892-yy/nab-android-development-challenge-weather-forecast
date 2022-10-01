package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

data class WeatherData(
    var city: City? = null,
    var cod: String? = null,
    var message: Int? = null,
    var cnt: Int? = null,
    var list: List<ListEntity>? = null
)

val DEFAULT_DAILY_WEATHER = WeatherData(
    city = null,
    cod = "",
    message = 0,
    cnt = 0,
    list = emptyList()
)