package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model

import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.ListEntity
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

/**
 * Mapper responsible for mapping [WeatherData] domain class into
 * its ui model representation (aka [WeatherItemUiModal]).
 */
class WeatherItemUiModelMapper {

    companion object{
        const val KELVIN_TO_CELSIUS_RATE: Double = 273.15
    }

    operator fun invoke(weatherData: WeatherData): List<WeatherItemUiModal> = weatherData.list?.map {
        it.toUiModel()
    } ?: emptyList()

    private fun ListEntity.toUiModel(): WeatherItemUiModal {
        val temperatureInKelvin = this.main?.temp ?: KELVIN_TO_CELSIUS_RATE
        val temperatureInCelsius = (temperatureInKelvin - KELVIN_TO_CELSIUS_RATE).roundToInt()
        return WeatherItemUiModal(
            datetime = this.dt ?: 0,
            dateString = this.dt?.toExpectedDateTime() ?: "",
            averageTemperature = "$temperatureInCelsius",
            pressure = this.main?.pressure?.toString() ?: "",
            humidity = "${this.main?.humidity ?: "0"}%",
            description = this.weather?.firstOrNull()?.description ?: "",
        )
    }

    private fun Int.toExpectedDateTime(): String {
        val dateFormatter = SimpleDateFormat("EEE, dd MMM yyyy", Locale.ENGLISH)
        val date = Date(this.toLong())
        return try {
            dateFormatter.format(date).toString()
        } catch (ex: Exception) {
            this.toString()
        }
    }
}
