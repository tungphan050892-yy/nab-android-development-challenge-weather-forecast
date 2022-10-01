package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mappers

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.FeelsLikeDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.FeelsLike

fun FeelsLikeDTO.toEntityObject() = FeelsLike(
    day = this.day,
    night = this.night,
    eve = this.eve,
    morn = this.morn
)

val DEFAULT_FEELSLIKE = FeelsLike(
    day = 0.0,
    night = 0.0,
    eve = 0.0,
    morn = 0.0
)