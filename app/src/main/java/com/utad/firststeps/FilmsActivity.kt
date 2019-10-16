package com.utad.firststeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import com.utad.firststeps.model.Movie
import kotlinx.android.synthetic.main.activity_films.*

class FilmsActivity : AppCompatActivity() {

    private val movie = Movie(
        id = 1,
        title = "Pulp Fiction",
        genre = "Thriller",
        year = "1996",
        description = "Lorem ipsum dolor sit amet consectetur adipiscing elit torquent aliquam nam augue varius libero, interdum pellentesque viverra inceptos congue conubia sollicitudin in gravida ridiculus curae. Primis aliquam porttitor quam dapibus magnis habitant nostra condimentum laoreet, maecenas praesent per non posuere himenaeos auctor parturient vel tempus, class inceptos platea augue feugiat convallis sodales ullamcorper. Inceptos volutpat lectus proin integer posuere egestas interdum, libero nec penatibus habitasse magna molestie cubilia feugiat, fringilla aliquet etiam mollis tortor senectus.",
        score = 8
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        with(movie){
            txtTitle.text = title
            txtScore.text = score.toString()
            txtGenreValue.text = genre
            txtProductionYearValue.text = year
            txtDescription.text = description
            Picasso.get().load("https://miro.medium.com/max/3838/1*kn8bIlpAIYbPQKqqnnpPeg.png").into(imgMovie)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("FilmDetailActivity", "OnStart Method")
    }

    override fun onResume() {
        super.onResume()
        Log.e("FilmDetailActivity", "OnResume method")
    }

    override fun onPause() {
        super.onPause()
        Log.e("FilmDetailActivity", "OnPause method")
    }

    override fun onStop() {
        super.onStop()
        Log.e("FilmDetailActivity", "OnStop method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("FilmDetailActivity", "OnDestroy method")
    }
}
