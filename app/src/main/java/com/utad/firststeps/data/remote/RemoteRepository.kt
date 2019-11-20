package com.utad.firststeps.data.remote

import com.utad.firststeps.model.*

interface RemoteRepository {
    suspend fun getMovies(map: Map<String, String>): List<Movie>?
    suspend fun getMovieDetail(id: String, api_key: String): MovieDetail?
    suspend fun getMovieCast(id: String, api_key: String): MovieCredit?
}