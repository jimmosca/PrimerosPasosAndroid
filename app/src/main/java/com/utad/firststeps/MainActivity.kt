package com.utad.firststeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseTxt: String = "# of times you have pressed: "

        var count: Int = 0

        val txtCount: TextView = findViewById(R.id.txtCount)
        txtCount.text = """$baseTxt$count"""

        val btnIncrease: Button = findViewById(R.id.btnIncrease)
        btnIncrease.text = "INCREASE!!!"
        btnIncrease.setOnClickListener {
            count++
            txtCount.text = """$baseTxt$count"""
        }
    }
}
