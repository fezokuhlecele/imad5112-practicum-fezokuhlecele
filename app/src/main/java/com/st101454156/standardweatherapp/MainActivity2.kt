package com.st101454156.standardweatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private lateinit var temperatures: Array<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        temperatures = arrayOf(
            findViewById(R.id.etDay1Temp),
            findViewById(R.id.etDay2Temp),
            // ... initialize other EditText views
        )

        findViewById<Button>(R.id.btnViewDetails).setOnClickListener {
            val tempValues = temperatures.map { it.text.toString().toDoubleOrNull() ?: 0.0 }.toDoubleArray()
            if (tempValues.all { it != 0.0 }) {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("TEMPERATURES", tempValues)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter temperatures for all days.", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finish() // Exit the app (not recommended, see previous responses)
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            temperatures.forEach { it.setText("") }
        }
    }
}