package com.st101454156.standardweatherapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openMainActivity2Button = findViewById<Button>(R.id.buttonCheckWeather)
        openMainActivity2Button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val exitButton = findViewById<Button>(R.id.buttonExit)
        exitButton.setOnClickListener {
            finish()
        }
    }
}