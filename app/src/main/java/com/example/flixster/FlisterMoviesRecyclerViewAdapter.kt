package com.example.flixster

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlisterMoviesRecyclerViewAdapter(
    private val movies: List<FlisterMovie>,
    private val mListener: OnListFragmentInteractionListener?
    ): RecyclerView.Adapter<FlisterMoviesRecyclerViewAdapter.MovieViewHolder> {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): FlisterMoviesRecyclerViewAdapter.MovieViewHolder {
            TODO("Not yet implemented")
        }
        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
            var mMovie: FlixsterMovie? = null
            var mMovieTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
            var mMovieDes: TextView = mView.findViewById<View>(R.id.movie_description) as TextView

            override fun tostring(): String{
                return mMovieTitle.toString() + " --"+ mMovieDes.text + "-- "
            }
        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int){
            val movie = movies[position]

            holder.mMovie = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieDes.text = movie.description

            holder.mView.setOnClickListener{
                holder.mMovie?.let {
                    movie -> mListener?.onItemClick(movie)
                }
            }
        }

        override fun getItemCount(): Int {
            return movies.size
        }
}