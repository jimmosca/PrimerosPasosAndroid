package com.utad.firststeps.model
const val posterBaseUrl = "http://image.tmdb.org/t/p/w342"
const val backdrpBaseUrl = "http://image.tmdb.org/t/p/w780"
//Search Fragment
data class Movie(
    val poster_path: String,
    val id: Int,
    val original_title: String,
    val title: String,
    val vote_average: Double,
    val release_date: String
)

data class SearchResult(val results: List<Movie>)

//MovieDetailActivity
data class MovieDetail(
    val backdrop_path: String,
    val title: String,
    val vote_average: Double,
    val release_date: String,
    val genres: List<MovieGenre>,
    val overview: String
)

data class MovieGenre(val name: String)

data class MovieCredit(
    val cast: List<MovieActor>,
    val crew: List<MovieDirector>
)

data class MovieActor(val name: String)

data class MovieDirector(val name: String, val job: String)