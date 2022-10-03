package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import vn.nab.innovation.center.assignment.android.tungphan.TestCoroutineRule
import vn.nab.innovation.center.assignment.android.tungphan.core.model.CallResult
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest.NoInternet
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData.Companion.DEFAULT_WEATHER_DATA
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData.Companion.DEFAULT_WEATHER_DATA_WITH_SINGLE_LIST_ITEM
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.usecase.GetThreeHoursStepWeatherDataUseCase
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model.WeatherItemUiModelMapper
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel.WeatherListState.Loading

//TODO: maybe should also write test for ui mapper class in ui layer?
class WeatherListViewModelTest {

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get: Rule
    val testCoroutineRule: TestCoroutineRule = TestCoroutineRule()

    private val getThreeHoursStepWeather: GetThreeHoursStepWeatherDataUseCase = mockk(relaxed = true)
    private val weatherItemUiModelMapper: WeatherItemUiModelMapper = WeatherItemUiModelMapper()

    private lateinit var tested: WeatherListViewModel

    private val screenStateObserver: Observer<WeatherListViewModel.WeatherListState> = mockk(relaxed = true)
    private val screenEventObserver: Observer<WeatherListViewModel.WeatherListScreenEvent> = mockk(relaxed = true)
//    private val categoriesObserver: Observer<CategoriesDataUiModel> = mockk(relaxed = true)

    @Before
    fun setUp() {
        `given tested view model`()
    }

    @Test
    fun `when the city name is less than 3 char, then ShowError event should be emitted`() = runTest {
        //Given
        tested.screenEvent.observeForever(screenEventObserver)

        //when
        tested.fetchThreeHoursStepWeatherData("sa")

        //then
        verify(exactly = 1) {
            screenEventObserver.onChanged(WeatherListViewModel.WeatherListScreenEvent.ShowError("City name is not long enough"))
        }
    }

    @Test
    fun `when the screen is open, then Loading state should be emitted`() = runTest {
        //Given
        tested.weatherDataState.observeForever(screenStateObserver)

        //when
        tested.fetchThreeHoursStepWeatherData("saigon")

        //then
        verify(exactly = 1) {
            screenStateObserver.onChanged(Loading(null))
        }
    }


    @Test
    fun `when screen is opened, and the get three hours step weather data fails with an error, then ShowError event with should be emitted`() =
        runTest {
            val exception = NoInternet
            coEvery { getThreeHoursStepWeather("saigon") } returns CallResult.failure(exception = exception)

            tested.screenEvent.observeForever(screenEventObserver)

            // When
            tested.fetchThreeHoursStepWeatherData("saigon")

            // Then
            verify {
                screenEventObserver.onChanged(
                    withArg {
                        it is WeatherListViewModel.WeatherListScreenEvent.ShowError
                    }
                )
            }
        }


    @Test
    fun `when screen is opened, and the get three hours step weather data is success, then Loaded state should be emitted`() =
        runTest {
            val exception = NoInternet
            coEvery { getThreeHoursStepWeather("saigon") } returns CallResult.success(DEFAULT_WEATHER_DATA_WITH_SINGLE_LIST_ITEM)

            tested.weatherDataState.observeForever(screenStateObserver)

            // When
            tested.fetchThreeHoursStepWeatherData("saigon")

            // Then
            verify {
                screenStateObserver.onChanged(
                    WeatherListViewModel.WeatherListState.Loaded(weatherItemUiModelMapper(DEFAULT_WEATHER_DATA_WITH_SINGLE_LIST_ITEM))
                )
            }
        }

    @Test
    fun `when screen is opened, and the get three hours step weather data is success but return empty list, then Empty state should be emitted`() =
        runTest {
            val exception = NoInternet
            coEvery { getThreeHoursStepWeather("saigon") } returns CallResult.success(DEFAULT_WEATHER_DATA)

            tested.weatherDataState.observeForever(screenStateObserver)

            // When
            tested.fetchThreeHoursStepWeatherData("saigon")

            // Then
            verify {
                screenStateObserver.onChanged(
                    WeatherListViewModel.WeatherListState.Empty()
                )
            }
        }

    private fun `given tested view model`() {
        tested = WeatherListViewModel(
            getThreeHoursStepWeather = getThreeHoursStepWeather,
            weatherItemUiModelMapper = weatherItemUiModelMapper
        )
    }
}
