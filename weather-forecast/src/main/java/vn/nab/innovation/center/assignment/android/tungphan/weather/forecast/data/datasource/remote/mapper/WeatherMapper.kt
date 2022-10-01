package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.WeatherDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Weather

fun WeatherDTO.toEntityObject() = Weather(
    id = this.id,
    main = this.main,
    description = this.description,
    icon = this.icon
)
