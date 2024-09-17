package com.example.flixster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment


private const val API_KEY = "ENTER API KEY"

class FlixsterMoviesFragment : Fragment(), OnListFragmentInteractionListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view = inflater.inflate.(R.layout.fragment_flixster_movies_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onItemClick(movie: FlixsterMovie) {
        TODO("Not yet implemented")
    }


}