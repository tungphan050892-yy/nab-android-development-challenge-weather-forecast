package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.Preferences
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.PreferencesProvider
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.WeatherLocalDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.local.WeatherLocalDataStoreImpl
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.WeatherRemoteDataSource
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.WeatherRemoteDataSourceImpl
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.AuthInterceptor
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.ConnectionChecker
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.ConnectionCheckerImpl
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.WeatherMapAPI
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.networkrequest.*
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.repository.WeatherDataProvider
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.entity.WeatherData
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.repository.WeatherDataRepository
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.domain.usecase.GetThreeHoursStepWeatherDataUseCase
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.model.WeatherItemUiModelMapper
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.screen.weather.WeatherListViewModel

//Weather Forecast Module for koin instantiate, centralize everything here or split them base on need
//Split and conquer, smaller is better most of the time
val weatherForecastModule = module {

    //region viewmodel
    viewModel {
        WeatherListViewModel(
            getThreeHoursStepWeather = get(),
            weatherItemUiModelMapper = get()
        )
    }

    factory {
        WeatherItemUiModelMapper()
    }
    //endregion

    //region use case
    factory {
        GetThreeHoursStepWeatherDataUseCase(
            weatherDataRepository = get()
        )
    }
    //endregion


    //region repository
    single<WeatherDataRepository> {
        WeatherDataProvider(
            weatherLocalDataSource = get(),
            weatherRemoteDataSource = get(),
            gson = get()
        )
    }
    //endregion

    //region remote data source
    single<WeatherRemoteDataSource> {
        WeatherRemoteDataSourceImpl(
            getDailyWeatherDataNetworkRequest = get(named("get-daily-weather-data-network-request")),
            getThreeHoursStepWeatherDataNetworkRequest = get(named("get-three-hours-step-weather-data-network-request"))
        )
    }

    single<NetworkRequest<WeatherData, GetDailyWeatherDataParams>>(named("get-daily-weather-data-network-request")) {
        GetDailyWeatherDataNetworkRequest(
            connectionChecker = get(),
            weatherMapApi = get()
        )
    }

    single<NetworkRequest<WeatherData, GetThreeHoursStepWeatherDataParams>>(named("get-three-hours-step-weather-data-network-request")) {
        GetThreeHoursStepWeatherDataNetworkRequest(
            connectionChecker = get(),
            weatherMapApi = get()
        )
    }

    single<ConnectionChecker> {
        val cm = androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        ConnectionCheckerImpl(connectivityManager = cm)
    }
    //endregion

    //region local data source
    single<WeatherLocalDataSource> {
        WeatherLocalDataStoreImpl(
            preferences = get()
        )
    }
    //endregion

    //region network
    factory { AuthInterceptor() }

    factory { provideOkHttpClient(get()) }

    factory { provideForecastApi(get()) }

    single { provideRetrofit(get()) }
    //end region

    //region local storage
    single<Preferences> {
        PreferencesProvider(androidApplication())
    }
    //endregion

    //region other
    single {
        Gson()
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideForecastApi(retrofit: Retrofit): WeatherMapAPI = retrofit.create(WeatherMapAPI::class.java)


