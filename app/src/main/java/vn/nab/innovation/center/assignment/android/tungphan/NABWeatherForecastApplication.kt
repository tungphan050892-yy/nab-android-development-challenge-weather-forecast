package vn.nab.innovation.center.assignment.android.tungphan

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.weatherForecastModule

class NABWeatherForecastApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin() {
        val modules = weatherForecastModule

        startKoin {
            androidContext(this@NABWeatherForecastApplication)
            modules(modules)
        }
    }

}