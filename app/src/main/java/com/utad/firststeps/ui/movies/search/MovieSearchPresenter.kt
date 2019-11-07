package com.utad.firststeps.ui.movies.search

import com.utad.firststeps.data.RetrofitFactory
import com.utad.firststeps.data.apiKey
import com.utad.firststeps.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MovieSearchPresenter(val view: MovieSearchView){

    init {

    }

    fun getMovies(query: String) {
        val moviesApi = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = moviesApi.getMovies(mapOf("api_key" to apiKey, "query" to query, "language" to Locale.getDefault().displayLanguage))
            withContext(Dispatchers.Main) {
                view.showMovieList(response.body()!!.results)
            }
        }
    }

}
interface MovieSearchView{
    fun showMovieList(movies: List<Movie>)
}