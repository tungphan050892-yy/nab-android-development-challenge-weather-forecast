package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.AuthInterceptor
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network.WeatherMapAPI

val weatherForecastModule = module {

    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideForecastApi(retrofit: Retrofit): WeatherMapAPI = retrofit.create(WeatherMapAPI::class.java)


