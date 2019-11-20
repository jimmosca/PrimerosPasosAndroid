package com.utad.firststeps.ui.movies.favorites

import com.utad.firststeps.data.local.LocalRepository
import com.utad.firststeps.model.Movie

class FavoritesPresenter(val view: FavoritesView, val localRepository: LocalRepository) {
    fun init(){
        view.listPassed(localRepository.getAll())
    }
}
interface FavoritesView {
    fun listPassed(movies: List<Movie>)

}