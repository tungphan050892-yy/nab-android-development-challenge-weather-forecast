package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.RainDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Rain

fun RainDTO.toEntityObject() = Rain(
    threeH = this.threeH
)