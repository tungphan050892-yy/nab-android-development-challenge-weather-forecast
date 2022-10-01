package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

data class FeelsLike(
    var day: Double? = null,
    var night: Double? = null,
    var eve: Double? = null,
    var morn: Double? = null
)

val DEFAULT_FEELSLIKE = FeelsLike(
    day = 0.0,
    night = 0.0,
    eve = 0.0,
    morn = 0.0
)