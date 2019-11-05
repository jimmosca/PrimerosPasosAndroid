package com.utad.firststeps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.firststeps.R
import com.utad.firststeps.model.Movie
import kotlinx.android.synthetic.main.activity_films_list.*;

class FilmsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films_list)

        val movieList = listOf(
            Movie(popularity = 13.03,
                voteCount = 597,
                video = false,
                poster_path = "https://image.tmdb.org/t/p/w500/peTl1V04E9ppvhgvNmSX0r2ALqO.jpg",
                id = 424781,
                adult = false,
                backdropPath = "/x832ykgj3fx0Q0MFKEno77XM47e.jpg",
                originalLanguage = "en",
                original_title = "Sorry to Bother You",
                genreIds = listOf(35, 14, 878),
                title = "Sorry to Bother You",
                vote_average = 6.9,
                overview = "In an alternate present-day version of Oakland, black telemarketer Cassius Green discovers a magical key to professional success – which propels him into a macabre universe.",
                release_date = "2018-07-06"),
            Movie(popularity = 33.276,
                voteCount = 16391,
                video = false,
                poster_path = "https://image.tmdb.org/t/p/w500/dM2w364MScsjFf8pfMbaWUcWrR.jpg",
                id = 680,
                adult = false,
                backdropPath = "/4cDFJr4HnXN5AdPw4AKrmLlMWdO.jpg",
                originalLanguage = "en",
                original_title = "Pulp Fiction",
                genreIds = listOf( 80, 53),
                title = "Pulp Fiction",
                vote_average = 8.5,
                overview = "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.",
                release_date = "1994-10-14"),
            Movie(popularity = 14.642,
                voteCount = 3734,
                video = false,
                poster_path = "https://image.tmdb.org/t/p/w500/fnaGmGCWgGOQjCpM0TqKPZJ5x85.jpg",
                id = 334533,
                adult = false,
                backdropPath = "/hzp6irYITiJc5JUA1GZhmbE10pD.jpg",
                originalLanguage = "en",
                original_title = "Captain Fantastic",
                genreIds = listOf( 12, 35, 18),
                title = "Captain Fantastic",
                vote_average = 8.0,
                overview = "A father living in the forests of the Pacific Northwest with his six young kids tries to assimilate back into society.",
                release_date = "2016-07-08")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(movieList)
    }
}
