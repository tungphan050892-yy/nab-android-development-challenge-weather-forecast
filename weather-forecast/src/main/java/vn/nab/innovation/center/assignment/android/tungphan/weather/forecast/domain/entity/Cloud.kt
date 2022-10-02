package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

data class Cloud(
    val all: Int? = null
){
    companion object{
        val DEFAULT_CLOUDS = Cloud(all = 0)
    }
}