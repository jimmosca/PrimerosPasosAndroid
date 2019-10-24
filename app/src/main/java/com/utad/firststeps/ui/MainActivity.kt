package com.utad.firststeps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.utad.firststeps.R

class MainActivity : AppCompatActivity() {
    private lateinit var txtCount: TextView
    private lateinit var btnIncrease: Button
    private lateinit var btnProfile: Button
    private lateinit var btnFilmsList: Button
    private var count = 1

    //API Token
    private val apiToken = "e618da2f60ee21d4245452db11f9040e"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIncrease = findViewById(R.id.btnIncrease)
        txtCount = findViewById(R.id.txtCount)
        btnProfile = findViewById(R.id.btnProfile)
        btnFilmsList = findViewById(R.id.btnFilmsList)


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

        btnFilmsList.setOnClickListener {
            val intent = Intent(this, FilmsListActivity::class.java)
            startActivity(intent)
        }
    }
    private fun changeText(timesPressed: Int) {
        val message: String = getString(R.string.base_text, timesPressed, timesPressed)
        txtCount.text = message
    }
    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "OnStart Method")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "OnResume method")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "OnPause method")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "OnStop method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "OnDestroy method")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Count", count)
        outState.putCharSequence("Message", txtCount.text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("Count")
        txtCount.text = savedInstanceState.getCharSequence("Message")
    }

}
