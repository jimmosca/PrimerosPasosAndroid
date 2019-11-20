package com.utad.firststeps.data.remote

import com.utad.firststeps.model.*

interface RemoteRepository {
    fun getMovies(map: Map<String, String>): List<Movie>
    fun getMovieDetail(id: String, api_key: String): MovieDetail
    fun getMovieCast(id: String, api_key: String): MovieCredit
}