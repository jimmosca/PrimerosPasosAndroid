package com.utad.firststeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var txtCount: TextView
    private lateinit var btnIncrease: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIncrease = findViewById(R.id.btnIncrease)
        txtCount = findViewById(R.id.txtCount)

        var count: Int = 0

        btnIncrease.setOnClickListener {
           changeText(count++)
        }
    }
    private fun changeText(timesPressed: Int) {
        val baseText: String = getString(R.string.base_text)
        txtCount.text = "$baseText $timesPressed"
    }
}
