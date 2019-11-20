package com.utad.firststeps.ui.movies.favorites

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
}
interface FavoritesView {
    fun listPassed(movies: List<Movie>)

}