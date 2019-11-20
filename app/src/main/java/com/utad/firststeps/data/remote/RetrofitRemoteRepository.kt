package com.utad.firststeps.data.remote

import com.utad.firststeps.model.Movie
import com.utad.firststeps.model.MovieCredit
import com.utad.firststeps.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RetrofitRemoteRepository(val moviesApi: MoviesApi): RemoteRepository {
    override fun getMovies(map: Map<String, String>): List<Movie> {
        var movieList = listOf<Movie>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = moviesApi.getMovies(map)
            if (response.isSuccessful)

            withContext(Dispatchers.Main){
                movieList = response.body()!!.results
            }
        }
        return movieList
    }

    override fun getMovieDetail(id: String, api_key: String): MovieDetail {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovieCast(id: String, api_key: String): MovieCredit {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}