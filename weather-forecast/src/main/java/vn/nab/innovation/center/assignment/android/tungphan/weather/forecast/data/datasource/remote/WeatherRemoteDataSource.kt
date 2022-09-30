package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote

interface WeatherRemoteDataSource {

    suspend fun getDailyWeatherData(): Result<List<Unit>>

}