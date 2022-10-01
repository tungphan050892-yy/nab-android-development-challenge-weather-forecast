package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import vn.nab.innovation.center.assignment.android.tungphan.core.viewmodel.state.ViewModelState
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model.WeatherItemUiModal
import kotlinx.coroutines.launch
import vn.nab.innovation.center.assignment.android.tungphan.core.livedata.SingleLiveEvent
import vn.nab.innovation.center.assignment.android.tungphan.core.logging.createLogger
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.usecase.GetThreeHoursStepWeatherDataUseCase
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model.WeatherItemUiModelMapper

class WeatherListViewModel(
    private val getThreeHoursStepWeather: GetThreeHoursStepWeatherDataUseCase,
    private val weatherItemUiModelMapper: WeatherItemUiModelMapper,
) : ViewModel() {

    private val logger = createLogger()

    private val _weatherDataState: MutableLiveData<WeatherListState> = MutableLiveData()
    val weatherDataState: LiveData<WeatherListState> = _weatherDataState

    private val _screenEvent = SingleLiveEvent<WeatherListScreenEvent>()
    val screenEvent: LiveData<WeatherListScreenEvent> = _screenEvent

    fun fetchThreeHoursStepWeatherData(
        location: String
    ) {
        _weatherDataState.value = WeatherListState.Loading()
        viewModelScope.launch {
            val result = getThreeHoursStepWeather(location = location)
            when {
                result.isSuccess -> {
                    result.getOrNull()?.let { weatherData ->
                        if (weatherData.list.isNullOrEmpty()) {
                            _weatherDataState.value = WeatherListState.Empty()
                        } else {
                            _weatherDataState.value = WeatherListState.Loaded(
                                weatherItemUiModelMapper(
                                    weatherData = weatherData
                                )
                            )
                        }
                    } ?: run {
                        _weatherDataState.value = WeatherListState.Empty()
                    }
                }
                else -> {
                    val exception = result.exceptionOrNull() // TODO display error message
                    _screenEvent.value = WeatherListScreenEvent.ShowError()
                }
            }
        }
    }

    fun openWeatherDetail(weatherDateTime: String) {
        //TODO: handle screen open
    }

    /**
     * Events upon which UI should take some action. The reason for not combining events and data
     * payload within the same live data is because some events depend upon the data - e.g.
     * list of saved-searches should still be shown if an [Error] occurs.
     */
    sealed class WeatherListScreenEvent {
        class ShowError : WeatherListScreenEvent() {
            override fun equals(other: Any?): Boolean = this === other
            override fun hashCode(): Int = System.identityHashCode(this)
        }
    }

    sealed class WeatherListState : ViewModelState {

        abstract val weatherItemUiModal: List<WeatherItemUiModal>?

        data class Loaded(
            override val weatherItemUiModal: List<WeatherItemUiModal>? = null
        ) : WeatherListState()

        data class Empty(
            override val weatherItemUiModal: List<WeatherItemUiModal>? = null
        ) : WeatherListState()

        data class Loading(
            override val weatherItemUiModal: List<WeatherItemUiModal>? = null
        ) : WeatherListState()

        data class ErrorOccur(
            override val weatherItemUiModal: List<WeatherItemUiModal>? = null
        ) : WeatherListState()
    }
}
