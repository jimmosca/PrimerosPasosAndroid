package com.utad.firststeps.ui.movies.detail

import com.utad.firststeps.data.remote.RetrofitFactory
import com.utad.firststeps.data.remote.apiKey
import com.utad.firststeps.model.MovieCredit
import com.utad.firststeps.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter (val view: MovieDetailView){

    private val moviesApi = RetrofitFactory.makeRetrofitService()

    fun getMovieDetails(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = moviesApi.getMovieDetail(id = id, api_key = apiKey)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    view.showMovieDetails(response.body()!!)
                }
            }
        }
    }

    fun getMovieCredits(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = moviesApi.getMovieCast(id = id, api_key = apiKey)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    view.showMovieCast(response.body()!!)
                }
            }
        }
    }

}

interface MovieDetailView {
    fun showMovieDetails(movieDetail: MovieDetail)
    fun showMovieCast(movieCast: MovieCredit)
}