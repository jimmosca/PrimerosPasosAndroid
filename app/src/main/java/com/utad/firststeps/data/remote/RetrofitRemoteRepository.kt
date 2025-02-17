package com.utad.firststeps.data.remote

import com.utad.firststeps.model.Movie
import com.utad.firststeps.model.MovieCredit
import com.utad.firststeps.model.MovieDetail

class RetrofitRemoteRepository(private val moviesApi: MoviesApi): RemoteRepository {
    override suspend fun getMovies(map: Map<String, String>): List<Movie>? {
        val movieSearchResponse = moviesApi.getMovies(map)
        return if (movieSearchResponse.isSuccessful)
            movieSearchResponse.body()!!.results
        else
            null
    }

    override suspend fun getMovieDetail(id: String, api_key: String): MovieDetail? {
        val movieDetailResponse = moviesApi.getMovieDetail(id, api_key)
        return if (movieDetailResponse.isSuccessful)
            movieDetailResponse.body()!!
        else
            null
    }

    override suspend fun getMovieCast(id: String, api_key: String): MovieCredit? {
        val movieCreditResponse = moviesApi.getMovieCast(id, api_key)
        return if (movieCreditResponse.isSuccessful)
            movieCreditResponse.body()!!
        else
            null
    }
}