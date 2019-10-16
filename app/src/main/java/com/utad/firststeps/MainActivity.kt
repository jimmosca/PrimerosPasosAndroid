package com.utad.firststeps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var txtCount: TextView
    private lateinit var btnIncrease: Button
    private lateinit var btnProfile: Button
    private lateinit var btnFilmDetail: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIncrease = findViewById(R.id.btnIncrease)
        txtCount = findViewById(R.id.txtCount)
        btnProfile = findViewById(R.id.btnProfile)
        btnFilmDetail = findViewById(R.id.btnFilmDetail)

        var count = 1

        btnIncrease.setOnClickListener {
           changeText(count++)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("name", "Jose Mateo")
            intent.putExtra("birth_date", "19/07/1996")
            intent.putExtra("city", "Madrid")
            intent.putExtra("image", R.drawable.pepe)
            intent.putExtra("description", "Lorem ipsum dolor sit amet consectetur adipiscing elit torquent aliquam nam augue varius libero, interdum pellentesque viverra inceptos congue conubia sollicitudin in gravida ridiculus curae. Primis aliquam porttitor quam dapibus magnis habitant nostra condimentum laoreet, maecenas praesent per non posuere himenaeos auctor parturient vel tempus, class inceptos platea augue feugiat convallis sodales ullamcorper. Inceptos volutpat lectus proin integer posuere egestas interdum, libero nec penatibus habitasse magna molestie cubilia feugiat, fringilla aliquet etiam mollis tortor senectus.\n" +
                    "\n" +
                    "Vestibulum conubia inceptos nec sollicitudin nostra curabitur ut morbi quis habitant proin, erat mauris hendrerit curae dapibus facilisi potenti vitae natoque. Bibendum magna varius per maecenas elementum quam suscipit, nulla ac nisl quis nam iaculis, fusce accumsan inceptos lectus vulputate ridiculus. Luctus quisque praesent proin purus aliquet nibh, inceptos litora arcu fusce est feugiat venenatis, magna id vivamus mus nulla.")
            startActivity(intent)
        }

        btnFilmDetail.setOnClickListener {
            val intent = Intent(this, FilmsActivity::class.java)
            startActivity(intent)
        }
    }
    private fun changeText(timesPressed: Int) {
        val message: String = getString(R.string.base_text, timesPressed, timesPressed)
        txtCount.text = message
    }
}
