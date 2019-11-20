package com.utad.firststeps.data.local

import com.utad.firststeps.model.Movie

interface LocalRepository{
    fun getAll(): List<Movie>
    fun addMovie(movie: Movie)
}