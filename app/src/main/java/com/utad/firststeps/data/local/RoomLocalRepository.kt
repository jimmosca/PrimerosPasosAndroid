package com.utad.firststeps.data.local

import com.utad.firststeps.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomLocalRepository(database: AppDatabase): LocalRepository{

    private val dao = database.movieDao()
    override suspend fun addMovie(movie: Movie) {
       dao.addMovie(movie)
    }

    override suspend fun isContained(id: Int): Int {
        return dao.isContained(id)
    }

    override suspend fun getAll(): List<Movie> {

        return dao.getAll()
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun deleteOne(id: Int){
        dao.deleteOne(id)
    }
    override suspend fun getByName(): List<Movie> {
        return dao.getByName()
    }

    override suspend fun getByDate(): List<Movie> {
        return dao.getByDate()
    }

}