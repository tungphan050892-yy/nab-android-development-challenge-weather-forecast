package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.mapper

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.dto.ListDTO
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Cloud.Companion.DEFAULT_CLOUDS
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.FeelsLike.Companion.DEFAULT_FEELSLIKE
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.ListEntity
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.Rain.Companion.DEFAULT_RAIN

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
    clouds = this.clouds?.toEntityObject()?: DEFAULT_CLOUDS,
    pop = this.pop,
    rain = this.rain?.toEntityObject() ?: DEFAULT_RAIN,
    main = this.main?.toEntityObject(),
    visibility = this.visibility,
    sys = this.sys?.toEntityObject(),
    dtTxt = this.dtTxt,
    wind = this.wind?.toEntityObject()
)
