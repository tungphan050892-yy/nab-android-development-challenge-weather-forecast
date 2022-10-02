package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model

/**
 * Represents a model used for displaying a list of weather item
 */
data class WeatherItemUiModal(
    val datetime: Int,
    val dateString: String,
    val averageTemperature: String,
    val pressure: String,
    val humidity: String,
    val description: String
)
