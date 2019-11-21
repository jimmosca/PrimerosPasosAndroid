package com.utad.firststeps.data.local

import com.utad.firststeps.model.Movie

interface LocalRepository{
    suspend fun getAll(): List<Movie>
    suspend fun addMovie(movie: Movie)
    suspend fun isContained(id: Int): Int
    suspend fun deleteOne(id: Int)
    suspend fun getByName(): List<Movie>
    suspend fun getByDate(): List<Movie>
    suspend fun deleteAll()
}