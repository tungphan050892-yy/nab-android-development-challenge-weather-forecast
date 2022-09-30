package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mappers

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.DailyWeatherResponseDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.City
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.Coordinate
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.DailyWeatherResponse


fun DailyWeatherResponseDTO.toEntityObject() = DailyWeatherResponse(
    city = this.city?.toEntityObject() ?: DEFAULT_CITY,
    cod = this.cod,
    message = this.message,
    cnt = this.cnt,
    list = this.list?.map { it.toEntityObject() } ?: emptyList()
)

//TODO: check with API team if the default value is good or will create side effect in null case
val DEFAULT_CITY = City(
    id = 0,
    name = "",
    coordinate = Coordinate(0.0, 0.0),
    country = "",
    population = 0,
    timezone = 0
)