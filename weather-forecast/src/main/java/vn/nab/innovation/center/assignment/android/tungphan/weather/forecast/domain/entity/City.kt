package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

//TODO: instead of nullable field, return default empty instance and remove nullable
data class City(
    var id: Int? = null,
    var name: String? = null,
    var coordinate: Coordinate? = null,
    var country: String? = null,
    var population: Int? = null,
    var timezone: Int? = null,
    var sunrise: Int? = null,
    var sunset: Int? = null,
)