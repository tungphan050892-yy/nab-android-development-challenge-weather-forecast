package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local

/**
 * Interface representing weather local data source.
 * Local data source for weather data acting as cache to reduce API call number
 */
interface WeatherLocalDataSource {

    var lastGetThreeHoursWeatherDataResponseTime: String


    var threeHoursStepWeatherData: String

}