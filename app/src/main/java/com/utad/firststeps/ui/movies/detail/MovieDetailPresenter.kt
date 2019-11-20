package com.utad.firststeps.ui.movies.detail

import com.utad.firststeps.data.local.LocalRepository
import com.utad.firststeps.data.remote.RemoteRepository
import com.utad.firststeps.data.remote.RetrofitFactory
import com.utad.firststeps.data.remote.apiKey
import com.utad.firststeps.model.Movie
import com.utad.firststeps.model.MovieCredit
import com.utad.firststeps.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter(
    private val view: MovieDetailView,
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {
    private var alreadyContained = false
    private var idMovie = 0
    fun init(id: String) {
        idMovie = id.toInt()
        CoroutineScope(Dispatchers.IO).launch {
            val movieDetail = remoteRepository.getMovieDetail(id, apiKey)
            val movieCast = remoteRepository.getMovieCast(id, apiKey)
            val existsOnDb = localRepository.isContained(id.toInt())
            withContext(Dispatchers.Main) {
                if (movieDetail != null) {
                    view.showMovieDetails(movieDetail)
                } else
                    view.showError()
                if (movieCast != null) {
                    view.showMovieCast(movieCast)
                } else
                    view.showError()
                if (existsOnDb == 1) {
                    view.showAsFavorite()
                    alreadyContained = true
                }
            }
        }
    }

    fun onFavoriteClicked() {
        if (alreadyContained) {
            view.showAsNoFavorite()
            CoroutineScope(Dispatchers.IO).launch {
                localRepository.deleteOne(idMovie)
            }

        } else {
            view.showAsFavorite()
            CoroutineScope(Dispatchers.IO).launch {
                var movieDetail = remoteRepository.getMovieDetail(idMovie.toString(), apiKey)
                if (movieDetail != null) {
                    localRepository.addMovie(
                        Movie(
                            id = idMovie,
                            title = movieDetail.title,
                            original_title = movieDetail.original_title,
                            poster_path = movieDetail.poster_path,
                            vote_average = movieDetail.vote_average,
                            release_date = movieDetail.release_date
                        )
                    )
                }
            }
        }

    }


}

interface MovieDetailView {
    fun showMovieDetails(movieDetail: MovieDetail)
    fun showMovieCast(movieCast: MovieCredit)
    fun showError()
    fun showAsFavorite()
    fun showAsNoFavorite()
}