package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.MainDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Main

fun MainDTO.toEntityObject() = Main(
    temp = this.temp,
    feelsLike = this.feelsLike,
    tempMin = this.tempMin,
    tempMax = this.tempMax,
    pressure = this.pressure,
    seaLevel = this.seaLevel,
    grndLevel = this.grndLevel,
    humidity = this.humidity,
    tempKf = this.tempKf
)