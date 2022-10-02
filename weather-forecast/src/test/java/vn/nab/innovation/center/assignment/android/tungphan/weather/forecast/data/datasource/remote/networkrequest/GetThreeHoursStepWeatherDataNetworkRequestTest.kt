package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.ConnectionChecker
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.WeatherMapAPI


internal class GetThreeHoursStepWeatherDataNetworkRequestTest {

    private val connectionChecker: ConnectionChecker = mockk(relaxed = true)
    private lateinit var tested: GetThreeHoursStepWeatherDataNetworkRequest
    private val mockWebServer = MockWebServer()

    @Test
    fun `when network call is successful, success is returned`() =
        runBlocking<Unit> {
            // Given
            MockResponse().apply {
                setResponseCode(200)
                setBody("{}")
            }.also { mockWebServer.enqueue(it) }

            `given internet connection`()
            `given tested network request`()

            // When
            val result = tested.execute(
                GetThreeHoursStepWeatherDataParams("saigon")
            )

            // Then
            result.isSuccess shouldBeEqualTo true
        }

    @Test
    fun `when network call is unsuccessful, failure is returned`() =
        runBlocking<Unit> {
            // Given
            MockResponse().apply {
                setResponseCode(500)
                setBody("{}")
            }.also { mockWebServer.enqueue(it) }

            `given internet connection`()
            `given tested network request`()

            // When
            val result = tested.execute(
                params = GetThreeHoursStepWeatherDataParams("saigon")
            )

            // Then
            result.isFailure shouldBeEqualTo true
        }

    private fun `given internet connection`() {
        coEvery { connectionChecker.hasInternetConnection() } returns true
    }

    private fun `given tested network request`() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockWebServer.url("/"))
            .client(OkHttpClient())
            .build()

        tested = GetThreeHoursStepWeatherDataNetworkRequest(
            weatherMapApi = retrofit.create(WeatherMapAPI::class.java),
            connectionChecker = connectionChecker
        )
    }

}

