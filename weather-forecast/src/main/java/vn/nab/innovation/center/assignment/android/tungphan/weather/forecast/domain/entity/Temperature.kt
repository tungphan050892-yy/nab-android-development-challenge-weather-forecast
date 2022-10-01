package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

data class Temperature(
    var day: Double? = null,
    var min: Double? = null,
    var max: Double? = null,
    var night: Double? = null,
    var eve: Double? = null,
    var morn: Double? = null
)