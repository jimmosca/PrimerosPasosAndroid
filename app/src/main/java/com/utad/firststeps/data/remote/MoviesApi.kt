package com.utad.firststeps.data.remote

import com.utad.firststeps.model.MovieCredit
import com.utad.firststeps.model.MovieDetail
import com.utad.firststeps.model.SearchResult
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

const val apiKey = "e618da2f60ee21d4245452db11f9040e"

interface MoviesApi {
    @GET("search/movie")
    suspend fun getMovies(@QueryMap map: Map<String, String>): Response<SearchResult>

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: String, @Query("api_key") api_key: String): Response<MovieDetail>

    @GET("movie/{id}/credits")
    suspend fun getMovieCast(@Path("id") id: String, @Query("api_key") api_key: String): Response<MovieCredit>
}

object RetrofitFactory {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    fun makeRetrofitService(): MoviesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MoviesApi::class.java)
    }
}