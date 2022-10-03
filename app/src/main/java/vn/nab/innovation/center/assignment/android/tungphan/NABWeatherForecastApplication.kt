package vn.nab.innovation.center.assignment.android.tungphan

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.weatherForecastModule

class NABWeatherForecastApplication: Application() {

    //TODO: normally this should managed by clean architecture as FirebaseManager
    //but for this assignment, I decided to implement this code as fast as possible
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initFirebase()
    }

    private fun initKoin() {
        val modules = weatherForecastModule

        startKoin {
            androidContext(this@NABWeatherForecastApplication)
            modules(modules)
        }
    }

    private fun initFirebase(){
        firebaseAnalytics = Firebase.analytics
    }

}