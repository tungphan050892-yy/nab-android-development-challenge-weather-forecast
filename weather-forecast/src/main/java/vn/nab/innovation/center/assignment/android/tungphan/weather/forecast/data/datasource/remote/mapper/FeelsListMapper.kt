package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.FeelsLikeDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.FeelsLike

fun FeelsLikeDTO.toEntityObject() = FeelsLike(
    day = this.day,
    night = this.night,
    eve = this.eve,
    morn = this.morn
)