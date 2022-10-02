package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

data class Rain(
    var threeH: Double? = null
) {
    companion object {
        val DEFAULT_RAIN = Rain(threeH = 0.0)
    }
}