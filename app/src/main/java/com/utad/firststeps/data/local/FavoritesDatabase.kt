package com.utad.firststeps.data.local

import android.content.Context
import androidx.room.*
import com.utad.firststeps.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    suspend fun getAll(): List<Movie>

    @Insert
    suspend fun addMovie(movie: Movie)

    @Query("SELECT * FROM movie ORDER BY title")
    suspend fun getByName(): List<Movie>

    @Query("SELECT * FROM movie ORDER BY dateCreated")
    suspend fun getByDate(): List<Movie>

    @Query("SELECT count(title) FROM movie WHERE id =:id")
    suspend fun isContained(id: Int): Int

}

@Database(entities = arrayOf(Movie::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}

object DatabaseFactory {
    fun get(context: Context): AppDatabase {
        return Room.databaseBuilder( context, AppDatabase::class.java, "favorites-database").build()
    }
}