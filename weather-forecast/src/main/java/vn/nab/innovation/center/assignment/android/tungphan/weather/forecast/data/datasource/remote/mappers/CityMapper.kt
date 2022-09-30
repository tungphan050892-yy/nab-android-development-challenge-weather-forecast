package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mappers

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.CityDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.City

fun CityDTO.toEntityObject() =  City(
    id = this.id,
    name = this.name,
    coordinate = this.coord.toEntityObject(),
    country = this.country,
    population = this.population,
    timezone = this.timezone
)