package com.utad.firststeps.ui

import android.view.LayoutInflater.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.utad.firststeps.R
import com.utad.firststeps.model.Movie

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>(){

    override fun getItemCount() = movieList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieItem = from(parent.context).inflate(R.layout.movie_item, parent, false) as androidx.constraintlayout.widget.ConstraintLayout

        return MovieViewHolder(movieItem)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]

        Picasso.get().load(currentMovie.posterPath).into(holder.image)
        holder.title.text = currentMovie.title
        holder.originalTitle.text = currentMovie.originalTitle
        holder.score.text = currentMovie.voteAverage.toString()
        holder.releaseDate.text = currentMovie.releaseDate

    }
}

class MovieViewHolder(view: androidx.constraintlayout.widget.ConstraintLayout): RecyclerView.ViewHolder(view){
    val image: ImageView = view.findViewById(R.id.imgMoviePoster)
    val title: TextView = view.findViewById(R.id.txtMovieTitle)
    val originalTitle: TextView = view.findViewById(R.id.txtMovieOriginalTitle)
    val score: TextView = view.findViewById(R.id.txtMovieScore)
    val releaseDate: TextView = view.findViewById(R.id.txtMovieReleaseDateField)
}