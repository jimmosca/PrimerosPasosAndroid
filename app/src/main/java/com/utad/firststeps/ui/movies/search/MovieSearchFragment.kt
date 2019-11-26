package com.utad.firststeps.ui.movies.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utad.firststeps.R
import com.utad.firststeps.data.remote.RetrofitFactory
import com.utad.firststeps.data.remote.RetrofitRemoteRepository
import com.utad.firststeps.model.Movie
import com.utad.firststeps.ui.movies.MovieAdapter
import com.utad.firststeps.ui.movies.detail.MovieDetailActivity

class MovieSearchFragment : Fragment(), MovieSearchView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchBar: SearchView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var txtNoResults: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_movie, container, false)
        txtNoResults = view.findViewById(R.id.txtNoResults)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        movieAdapter = MovieAdapter {
            val intent = Intent(this.context, MovieDetailActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
        recyclerView.adapter = movieAdapter

        val presenter = MovieSearchPresenter(this, RetrofitRemoteRepository(RetrofitFactory.makeRetrofitService()))

        searchBar = view.findViewById(R.id.searchView)
        searchBar.queryHint = getString(R.string.search_hint)

        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {

                presenter.getMovies(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })

        return view
    }

    override fun showMovieList(movies: List<Movie>) {
        txtNoResults.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        movieAdapter.addMovies(movies)
    }

    override fun showNoResults() {
        recyclerView.visibility = View.GONE
        txtNoResults.visibility = View.VISIBLE
    }

}
