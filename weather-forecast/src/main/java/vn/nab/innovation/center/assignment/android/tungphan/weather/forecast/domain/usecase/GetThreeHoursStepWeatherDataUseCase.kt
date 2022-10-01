package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.usecase

import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository.WeatherDataRepository

/**
 * Use case responsible to get three hours step weather data from data source
 */
class GetThreeHoursStepWeatherDataUseCase(
    private val weatherDataRepository: WeatherDataRepository
) {

    suspend operator fun invoke(
        location: String,
    ): CallResult<WeatherData> = weatherDataRepository.getThreeHoursStepWeatherData(
        location = location
    )
}
