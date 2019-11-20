package com.utad.firststeps.ui.movies.search

import com.utad.firststeps.data.remote.RemoteRepository
import com.utad.firststeps.data.remote.RetrofitFactory
import com.utad.firststeps.data.remote.apiKey
import com.utad.firststeps.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(
    private val view: MovieSearchView,
    private val remoteRepository: RemoteRepository
) {

    fun getMovies(query: String) {
        if (query.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                val movies = remoteRepository.getMovies(
                    mapOf(
                        "api_key" to apiKey,
                        "query" to query
                    )
                )
                withContext(Dispatchers.Main) {
                    if (movies!!.isNotEmpty())
                        view.showMovieList(movies)
                    else
                        view.showNoResults()
                }
            }
        }
    }

}

interface MovieSearchView {
    fun showMovieList(movies: List<Movie>)
    fun showNoResults()
}