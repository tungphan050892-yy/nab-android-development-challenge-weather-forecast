package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local

/**
 * Concrete implementation of [WeatherLocalDataSource] implemented using in memory persistence solution.
 * start with SharedPreference, TODO: migrate to room later for performance, scalability, migration, versioning, etc
 */
class WeatherLocalDataStoreImpl(
    private val preferences: Preferences
) : WeatherLocalDataSource {

    override var lastGetThreeHoursWeatherDataResponseTime: String
        get() = preferences.lastGetThreeHoursWeatherDataResponseTime
        set(value) {
            preferences.lastGetThreeHoursWeatherDataResponseTime = value
        }

    override var threeHoursStepWeatherData: String
        get() = preferences.threeHoursStepWeatherData
        set(value) {
            preferences.threeHoursStepWeatherData = value
        }

}
