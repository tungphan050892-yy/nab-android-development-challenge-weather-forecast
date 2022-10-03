package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network

import okhttp3.Interceptor
import okhttp3.Response
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.BuildConfig

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        // TODO: find another way to hide this appid (api key) cause its credential
        val url = request.url().newBuilder().addQueryParameter("appid", BuildConfig.ONE_WEATHER_MAP_APP_ID_KEY).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}