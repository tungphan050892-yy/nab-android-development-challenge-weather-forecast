package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mappers

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.ListDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.FeelsLike
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entities.ListEntity

fun ListDTO.toEntityObject() = ListEntity(
    dt = this.dt,
    sunrise = this.sunrise,
    sunset = this.sunset,
    temp = this.temp?.toEntityObject(),
    feelsLike = this.feelsLike?.toEntityObject() ?: DEFAULT_FEELSLIKE,
    pressure = this.pressure,
    humidity = this.humidity,
    weather = this.weather?.map { it.toEntityObject() } ?: emptyList(),
    speed = this.speed,
    deg = this.deg,
    gust = this.gust,
    clouds = this.clouds,
    pop = this.pop,
    rain = this.rain
)

val DEFAULT_FEELSLIKE = FeelsLike(
    day = 0.0,
    night = 0.0,
    eve = 0.0,
    morn = 0.0
)
