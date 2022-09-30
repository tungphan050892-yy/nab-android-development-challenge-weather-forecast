package vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.data.datasource.remote.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        // TODO: find another way to hide this appid (api key) cause its credential
        val url = request.url().newBuilder().addQueryParameter("appid", "345dfc20c8ea29164e83df251b0b55a3").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}