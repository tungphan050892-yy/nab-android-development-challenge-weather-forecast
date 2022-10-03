package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.repository

import com.google.gson.Gson
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Rule
import org.junit.Test
import vn.nab.innovation.center.assignment.android.tungphan.TestCoroutineRule
import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.WeatherLocalDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.WeatherRemoteDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData.Companion.DEFAULT_WEATHER_DATA

//TODO: maybe should also write test for mapper class in data layer?
internal class WeatherDataProviderTest {

    private val weatherRemoteDataSource: WeatherRemoteDataSource = mockk(relaxed = true)
    private val weatherLocalDataSource: WeatherLocalDataSource = mockk(relaxed = true)
    private lateinit var tested: WeatherDataProvider

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Test
    fun `when get three hours step weather data remotely finished successfully, search arguments are saved`() =
        runTest {
            // Given
            val cityName = "saigon"

            coEvery {
                weatherRemoteDataSource.getThreeHoursStepWeatherData(
                    cityName = cityName,
                )
            } returns CallResult.success(DEFAULT_WEATHER_DATA)

            `given tested data provider`()

            // When
            val result = tested.getThreeHoursStepWeatherData(
                cityName = cityName,
            )

            // Then
            result shouldBeEqualTo CallResult.success(DEFAULT_WEATHER_DATA)
        }

    @Test
    fun `when get three hours step weather data remotely is failed, then result isFailure should be true`() =
        runTest {
            // Given
            val cityName = "saigon"

            coEvery {
                weatherRemoteDataSource.getThreeHoursStepWeatherData(
                    cityName = cityName,
                )
            } returns CallResult.failure(Exception())

            `given tested data provider`()

            // When
            val result = tested.getThreeHoursStepWeatherData(
                cityName = cityName,
            )

            // Then
            result.isFailure shouldBeEqualTo true
        }

    private fun `given tested data provider`() {
        tested = WeatherDataProvider(
            weatherLocalDataSource = weatherLocalDataSource,
            weatherRemoteDataSource = weatherRemoteDataSource,
            gson = Gson()
        )
    }

}