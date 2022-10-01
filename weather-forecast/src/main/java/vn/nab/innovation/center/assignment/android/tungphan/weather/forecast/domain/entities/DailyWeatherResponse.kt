package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities

data class DailyWeatherResponse(
    var city: City? = null,
    var cod: String? = null,
    var message: Double? = null,
    var cnt: Int? = null,
    var list: List<ListEntity>? = null
)