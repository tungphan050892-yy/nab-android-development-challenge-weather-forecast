package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WindDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Wind

fun WindDTO.toEntityObject() = Wind(
    speed = this.speed,
    deg = this.deg,
    gust = this.gust
)