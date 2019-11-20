package com.utad.firststeps.data.local

import com.utad.firststeps.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomLocalRepository(val database: AppDatabase): LocalRepository{

    val dao = database.movieDao()
    override fun addMovie(movie: Movie) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.addMovie(movie)
        }
    }

    override fun getAll(): List<Movie> {
        var movieList: List<Movie> = listOf()
        CoroutineScope(Dispatchers.IO).launch {

            movieList = dao.getAll()
        }
        return movieList
    }
}