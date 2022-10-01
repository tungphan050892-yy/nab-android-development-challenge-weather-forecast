package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.CoordDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Coordinate

fun CoordDTO?.toEntityObject() = Coordinate(
    lon = this?.lon ?: 0.0,
    lat = this?.lat ?: 0.0
)