package com.utad.firststeps.ui.movies.detail

import com.utad.firststeps.data.local.LocalRepository
import com.utad.firststeps.data.remote.RemoteRepository
import com.utad.firststeps.data.remote.RetrofitFactory
import com.utad.firststeps.data.remote.apiKey
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

    private val moviesApi = RetrofitFactory.makeRetrofitService()

    fun init(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response0 = moviesApi.getMovieDetail(id = id, api_key = apiKey)
            val response1 = moviesApi.getMovieCast(id = id, api_key = apiKey)
            withContext(Dispatchers.Main) {
                if (response0.isSuccessful) {
                    view.showMovieDetails(response0.body()!!)
                }
                if (response1.isSuccessful) {
                    view.showMovieCast(response1.body()!!)
                }
            }
        }
    }


}

interface MovieDetailView {
    fun showMovieDetails(movieDetail: MovieDetail)
    fun showMovieCast(movieCast: MovieCredit)
}