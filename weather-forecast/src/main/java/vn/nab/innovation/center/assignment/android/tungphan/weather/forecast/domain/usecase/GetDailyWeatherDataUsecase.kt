package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.usecase

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository.WeatherDataRepository

class GetDailyWeatherDataUseCase(
    private val weatherDataRepository: WeatherDataRepository
) {

    suspend operator fun invoke(
        location: String,
        cnt: String
    ): CallResult<WeatherData> = weatherDataRepository.getDailyWeatherData(
        location = location,
        cnt = cnt
    )
}