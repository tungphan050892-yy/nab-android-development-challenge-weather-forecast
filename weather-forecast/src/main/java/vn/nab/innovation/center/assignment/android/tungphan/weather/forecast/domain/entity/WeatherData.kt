package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.ListEntity.Companion.DEFAULT_LIST_ITEM

data class WeatherData(
    var city: City? = null,
    var cod: String? = null,
    var message: Int? = null,
    var cnt: Int? = null,
    var list: List<ListEntity>? = null
){
    companion object{
        val DEFAULT_WEATHER_DATA = WeatherData(
            city = null,
            cod = "",
            message = 0,
            cnt = 0,
            list = emptyList()
        )
        val DEFAULT_WEATHER_DATA_WITH_SINGLE_LIST_ITEM = WeatherData(
            city = null,
            cod = "",
            message = 0,
            cnt = 0,
            list = listOf(DEFAULT_LIST_ITEM)
        )
    }
}