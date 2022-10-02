package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model

import vn.nab.innovation.center.assignment.android.tungphan.core.logging.createLogger
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.ListEntity
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData

/**
 * Mapper responsible for mapping [WeatherData] domain class into
 * its ui model representation (aka [WeatherItemUiModal]).
 */
class WeatherItemUiModelMapper {

    operator fun invoke(weatherData: WeatherData): List<WeatherItemUiModal> = weatherData.list?.map {
        it.toUiModel()
    } ?: emptyList()

    private fun ListEntity.toUiModel(): WeatherItemUiModal {
        val item = WeatherItemUiModal(
            dateString = this.dt.toString(),
            averageTemperature = this.main?.temp?.toString() ?: "",
            pressure = this.main?.pressure?.toString() ?: "",
            humidity = this.main?.humidity?.toString() ?: "",
            description = this.weather?.firstOrNull()?.description ?: "",
        )

        createLogger().error(
            "dateString: ${item.dateString} " +
                    "dateString: ${item.averageTemperature} " +
                    "dateString: ${item.pressure} " +
                    "dateString: ${item.humidity} " +
                    "dateString: ${item.description} "
        )
        return item
    }
}
