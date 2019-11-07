package com.utad.firststeps.ui.movies.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utad.firststeps.R
import com.utad.firststeps.ui.movies.MovieAdapter
import com.utad.firststeps.ui.movies.detail.FilmDetailActivity

class MovieSearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchBar: SearchView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_movie, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = MovieAdapter {
            val intent = Intent(this.context, FilmDetailActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }

        searchBar = view.findViewById(R.id.searchView)
        searchBar.queryHint = getString(R.string.search_hint)

        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                if (!newText.isEmpty())
                    Log.e("MovieSearchFragment", newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })

        return view
    }




}
