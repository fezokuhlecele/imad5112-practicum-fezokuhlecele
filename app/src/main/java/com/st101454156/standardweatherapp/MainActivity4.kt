package com.st101454156.standardweatherapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4<Button : View?> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            val dailyWeatherList =
                intent.getParcelableArrayExtra("DAILY_WEATHER_LIST") as? Array<DailyWeather>
            val detailsTextView = findViewById<TextView>(R.id.tvDailyDetails)

            val detailsText = dailyWeatherList?.joinToString("\n\n") { dailyWeather ->
                "${dailyWeather.dayOfWeek}:\nMin: ${dailyWeather.minTemp}°C, Max: ${dailyWeather.maxTemp}°C, Condition: ${dailyWeather.condition}"
            } ?: "No weather data available"

            detailsTextView.text = detailsText

            findViewById<Button>(R.id.btnBackToMain2).setOnClickListener {
                finish() // Go back to MainActivity2 (Screen 2)
            }

            findViewById<Button>(R.id.btnBackToMain1).setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent) // Navigate to MainActivity (Screen 1)
            }
        }
    }
    }

private fun <Button> Button.setOnClickListener(function: () -> Unit): WindowInsetsCompat {
    TODO("Not yet implemented")
}


