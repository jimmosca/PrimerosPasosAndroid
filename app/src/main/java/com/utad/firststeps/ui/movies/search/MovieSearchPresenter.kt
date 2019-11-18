package com.utad.firststeps.ui.movies.search

import com.utad.firststeps.data.remote.RetrofitFactory
import com.utad.firststeps.data.remote.apiKey
import com.utad.firststeps.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(val view: MovieSearchView) {

    fun getMovies(query: String) {
        if (!query.isEmpty()) {
            val moviesApi = RetrofitFactory.makeRetrofitService()
            CoroutineScope(Dispatchers.IO).launch {
                val response = moviesApi.getMovies(
                    mapOf(
                        "api_key" to apiKey,
                        "query" to query
                    )
                )
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        if (response.body()!!.results.isNotEmpty())
                            view.showMovieList(response.body()!!.results)
                        else
                            view.showNoResults()
                    }
                }
            }
        }
    }

}

interface MovieSearchView {
    fun showMovieList(movies: List<Movie>)
    fun showNoResults()
}