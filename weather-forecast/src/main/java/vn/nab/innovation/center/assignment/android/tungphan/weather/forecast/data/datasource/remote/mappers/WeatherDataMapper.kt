package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mappers

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.TempDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WeatherDataDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.City
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.ListEntity
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.Temperature
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.WeatherData

fun WeatherDataDTO.toEntityObject() = WeatherData(
    city = this.city?.toEntityObject(),
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    list = this.listDTO?.map {
        it.toEntityObject()
    } ?: emptyList(),
)