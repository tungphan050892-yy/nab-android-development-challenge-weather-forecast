package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WeatherDataDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData

fun WeatherDataDTO.toEntityObject() = WeatherData(
    city = this.city?.toEntityObject(),
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    list = this.listDTO?.map {
        it.toEntityObject()
    } ?: emptyList(),
)