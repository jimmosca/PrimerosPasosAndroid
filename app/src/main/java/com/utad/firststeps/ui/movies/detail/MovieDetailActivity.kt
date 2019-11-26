package com.utad.firststeps.ui.movies.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.utad.firststeps.R
import com.utad.firststeps.data.local.DatabaseFactory
import com.utad.firststeps.data.local.RoomLocalRepository
import com.utad.firststeps.data.remote.RetrofitFactory
import com.utad.firststeps.data.remote.RetrofitRemoteRepository
import com.utad.firststeps.model.*
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity(), MovieDetailView {


    private lateinit var presenter: MovieDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)



        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.movie_detail)

        val id: String = intent.extras?.getInt("id")!!.toString()

        presenter = MovieDetailPresenter(
            this,
            RetrofitRemoteRepository(RetrofitFactory.makeRetrofitService()),
            RoomLocalRepository(DatabaseFactory.get(this))
        )

        presenter.init(id)

        btnFavorites.setOnClickListener {
            presenter.onFavoriteClicked()
        }


    }

    override fun showMovieDetails(movieDetail: MovieDetail) {
        Picasso.get().load(backdrpBaseUrl + movieDetail.backdrop_path).into(imgMovie)
        txtTitle.text = movieDetail.title
        txtGenreValue.text = movieDetail.genres.joinToString(", ") { it.name }
        txtProductionYearValue.text = movieDetail.release_date
        txtDescription.text = movieDetail.overview
    }

    override fun showMovieCast(movieCast: MovieCredit) {
        txtDirectorValue.text =
            movieCast.crew.filter { it.job.equals("Director") }.joinToString(", ") { it.name }
        txtCastValue.text = movieCast.cast.joinToString(", ") { it.name }
    }

    override fun showError() {
        progressBar.visibility = View.GONE
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    override fun showAsFavorite() {
        btnFavorites.setImageResource(R.drawable.filled_star)
    }

    override fun showAsNoFavorite() {
        btnFavorites.setImageResource(R.drawable.empty_star)
    }
    override fun setEnableBtnFavorite(enable: Boolean) {
        btnFavorites.isEnabled = enable
    }
    override fun showDetailsContainer() {
        detailContainer.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }
}
