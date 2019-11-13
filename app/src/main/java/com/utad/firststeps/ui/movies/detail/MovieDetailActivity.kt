package com.utad.firststeps.ui.movies.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.utad.firststeps.R
import com.utad.firststeps.model.*

class MovieDetailActivity : AppCompatActivity(), MovieDetailView {

    private lateinit var txtTitle: TextView
    private lateinit var txtGenreValue: TextView
    private lateinit var txtProductionYearValue: TextView
    private lateinit var txtDirectorValue: TextView
    private lateinit var txtCastValue: TextView
    private lateinit var txtDescription: TextView
    private lateinit var imgMovie: ImageView
    private val presenter = MovieDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        txtTitle = findViewById(R.id.txtTitle)
        txtGenreValue = findViewById(R.id.txtGenreValue)
        txtProductionYearValue = findViewById(R.id.txtProductionYearValue)
        txtDirectorValue = findViewById(R.id.txtDirectorValue)
        txtCastValue = findViewById(R.id.txtCastValue)
        txtDescription = findViewById(R.id.txtDescription)
        imgMovie = findViewById(R.id.imgMovie)

        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.movie_detail)

        val id: String = intent.extras?.getInt("id")!!.toString()

        presenter.getMovieDetails(id)
        presenter.getMovieCredits(id)

    }
    override fun showMovieDetails(movieDetail: MovieDetail) {
        Picasso.get().load(backdrpBaseUrl + movieDetail.backdrop_path).into(imgMovie)
        txtTitle.text = movieDetail.title
        txtGenreValue.text = movieDetail.genres.joinToString(", ")  { it.name }
        txtProductionYearValue.text = movieDetail.release_date
        txtDescription.text = movieDetail.overview
    }

    override fun showMovieCast(movieCast: MovieCredit) {
        txtDirectorValue.text = movieCast.crew.filter { it.job.equals( "Director") }.joinToString(", ") { it.name }
        txtCastValue.text = movieCast.cast.joinToString(", ") {it.name}
    }
}
