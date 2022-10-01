package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mappers

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WindDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.Wind

fun WindDTO.toEntityObject() = Wind(
    speed = this.speed,
    deg = this.deg,
    gust = this.gust
)