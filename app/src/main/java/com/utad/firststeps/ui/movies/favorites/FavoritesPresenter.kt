package com.utad.firststeps.ui.movies.favorites

import android.util.Log
import com.utad.firststeps.data.local.LocalRepository
import com.utad.firststeps.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesPresenter(private val view: FavoritesView, private val localRepository: LocalRepository) {
    fun init(){
        CoroutineScope(Dispatchers.IO).launch {
            val favorites = localRepository.getAll()
            withContext(Dispatchers.Main){
                view.listPassed(favorites)
            }
        }
    }

    fun onOrderByDateClicked() {
        CoroutineScope(Dispatchers.IO).launch {
            val favorites = localRepository.getByDate()
            withContext(Dispatchers.Main){
                view.listPassed(favorites)
            }
        }
    }

    fun onOrderByNameClicked() {
        CoroutineScope(Dispatchers.IO).launch {
            val favorites = localRepository.getByName()
            withContext(Dispatchers.Main){
                view.listPassed(favorites)
            }
        }
    }

    fun onDeleteClicked() {
        view.showDeleteDialog()
        Log.e("Presenter", "OnDeleteClicked")
    }

    fun delete(){
        CoroutineScope(Dispatchers.IO).launch {
            localRepository.deleteAll()
            withContext(Dispatchers.Main){
                view.listPassed(listOf())
            }
        }
    }
}
interface FavoritesView {
    fun listPassed(movies: List<Movie>)
    fun showDeleteDialog()

}