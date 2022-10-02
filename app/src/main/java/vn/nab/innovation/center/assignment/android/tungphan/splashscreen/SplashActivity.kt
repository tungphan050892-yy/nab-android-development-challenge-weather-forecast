package vn.nab.innovation.center.assignment.android.tungphan.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import vn.nab.innovation.center.assignment.android.tungphan.R
import vn.nab.innovation.center.assignment.android.tungphan.weather.forecast.ui.WeatherForecastActivity

// TODO: implement splash screen as next step
class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startWeatherActivity()
    }

    private fun startWeatherActivity() {
        startActivity(Intent(this, WeatherForecastActivity::class.java))
    }
}
