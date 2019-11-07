package com.utad.firststeps.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.utad.firststeps.R
import com.utad.firststeps.model.Movie

class MovieAdapter(private val listener: (Movie) -> Unit) : RecyclerView.Adapter<MovieViewHolder>(){

    private var movieList = listOf<Movie>()

    fun addMovies(movies: List<Movie>) {
        movieList = movies
        notifyDataSetChanged()
    }

    override fun getItemCount() = movieList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {


        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]

        holder.bind(currentMovie, listener)

    }

}

class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val image: ImageView = view.findViewById(R.id.imgMoviePoster)
    private val title: TextView = view.findViewById(R.id.txtMovieTitle)
    private val originalTitle: TextView = view.findViewById(R.id.txtMovieOriginalTitle)
    private val score: TextView = view.findViewById(R.id.txtMovieScore)
    private val releaseDate: TextView = view.findViewById(R.id.txtMovieReleaseDateValue)

    fun bind(movie: Movie, listener: (Movie) -> Unit) {
        Picasso.get().load(movie.poster_path).into(image)
        title.text = movie.title
        originalTitle.text = movie.original_title
        score.text = movie.vote_average.toString()
        releaseDate.text = movie.release_date
        this.itemView.setOnClickListener { listener.invoke(movie) }
    }
    companion object{
        fun from(parent: ViewGroup): MovieViewHolder {
            val movieItem = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
            return MovieViewHolder(movieItem)
        }
    }

}