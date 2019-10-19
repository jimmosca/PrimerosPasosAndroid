package com.utad.firststeps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.utad.firststeps.model.Movie

class MainActivity : AppCompatActivity() {
    private lateinit var txtCount: TextView
    private lateinit var btnIncrease: Button
    private lateinit var btnProfile: Button
    private lateinit var btnFilmDetail: Button
    private var count = 1

    //API Token
    private val apiToken = "e618da2f60ee21d4245452db11f9040e"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIncrease = findViewById(R.id.btnIncrease)
        txtCount = findViewById(R.id.txtCount)
        btnProfile = findViewById(R.id.btnProfile)
        btnFilmDetail = findViewById(R.id.btnFilmDetail)


        val movieList = listOf<Movie>(
            Movie(popularity = 13.03,
                  voteCount = 597,
                  video = false,
                  posterPath = "/peTl1V04E9ppvhgvNmSX0r2ALqO.jpg",
                  id = 424781,
                  adult = false,
                  backdropPath = "/x832ykgj3fx0Q0MFKEno77XM47e.jpg",
                  originalLanguage = "en",
                  originalTitle = "Sorry to Bother You",
                  genreIds = listOf(35, 14, 878),
                  title = "Sorry to Bother You",
                  voteAverage = 6.9,
                  overview = "In an alternate present-day version of Oakland, black telemarketer Cassius Green discovers a magical key to professional success – which propels him into a macabre universe.",
                  releaseDate = "2018-07-06"),
            Movie(popularity = 33.276,
                voteCount = 16391,
                video = false,
                posterPath = "/dM2w364MScsjFf8pfMbaWUcWrR.jpg",
                id = 680,
                adult = false,
                backdropPath = "/4cDFJr4HnXN5AdPw4AKrmLlMWdO.jpg",
                originalLanguage = "en",
                originalTitle = "Pulp Fiction",
                genreIds = listOf( 80, 53),
                title = "Pulp Fiction",
                voteAverage = 8.5,
                overview = "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.",
                releaseDate = "1994-10-14"),
            Movie(popularity = 14.642,
                voteCount = 3734,
                video = false,
                posterPath = "/fnaGmGCWgGOQjCpM0TqKPZJ5x85.jpg",
                id = 334533,
                adult = false,
                backdropPath = "/hzp6irYITiJc5JUA1GZhmbE10pD.jpg",
                originalLanguage = "en",
                originalTitle = "Captain Fantastic",
                genreIds = listOf( 12, 35, 18),
                title = "Captain Fantastic",
                voteAverage = 8.0,
                overview = "A father living in the forests of the Pacific Northwest with his six young kids tries to assimilate back into society.",
                releaseDate = "2016-07-08")
        )

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
