package com.utad.firststeps.ui.movies.favorites


import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.Room.databaseBuilder

import com.utad.firststeps.R
import com.utad.firststeps.data.local.AppDatabase
import com.utad.firststeps.data.local.DatabaseFactory
import com.utad.firststeps.data.local.LocalRepository
import com.utad.firststeps.data.local.RoomLocalRepository
import com.utad.firststeps.model.Movie
import com.utad.firststeps.ui.movies.MovieAdapter
import com.utad.firststeps.ui.movies.detail.MovieDetailActivity


class FavoritesFragment : Fragment(), FavoritesView {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MovieAdapter
    lateinit var presenter: FavoritesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        adapter = MovieAdapter {
            val intent = Intent(this.context, MovieDetailActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
        recyclerView = view.findViewById(R.id.recyclerViewFavorites)

        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter



        presenter =
            FavoritesPresenter(this, RoomLocalRepository(DatabaseFactory.get(this.context!!)))

        presenter.init()


        // Inflate the layout for this fragment
        return view
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        presenter.init()
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorites_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.menuBtnOrderDate -> presenter.onOrderByDateClicked()
            R.id.menuBtnOrderTitle -> presenter.onOrderByNameClicked()
            R.id.menuBtnDelete -> presenter.onDeleteClicked()

        }

        return true
    }

    override fun listPassed(movies: List<Movie>) {
        adapter.addMovies(movies)
    }

    override fun showDeleteDialog() {
        val builder = AlertDialog.Builder(this.context)
        builder.setMessage("Do you want to delete ALL your favorites?")
            .setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
                presenter.delete()
            }
            .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
        builder.create().show()
    }
}
