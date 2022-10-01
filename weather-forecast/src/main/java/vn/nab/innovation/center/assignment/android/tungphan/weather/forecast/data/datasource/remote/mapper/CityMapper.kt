package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.CityDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.City

fun CityDTO.toEntityObject() = City(
    id = this.id,
    name = this.name,
    coordinate = this.coord.toEntityObject(),
    country = this.country,
    population = this.population,
    timezone = this.timezone,
    sunrise = this.sunrise,
    sunset = this.sunset
)