package com.example.flixster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler.JSON
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import okhttp3.Response


private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"

class FlixsterMoviesFragment : Fragment(), OnListFragmentInteractionListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_flixster_movies_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progressionBar) as ContentLoadingProgressBar
        val movieListRecyclerView = view.findViewById<View>(R.id.movieList) as RecyclerView
        val context = view.context
        movieListRecyclerView.layoutManager = LinearLayoutManager(context)
        updateAdapter(progressBar, movieListRecyclerView)
        return view
    }




    private fun updateAdapter(progressBar: ContentLoadingProgressBar, movieListRecyclerView: RecyclerView){
        progressBar.show()

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api_key"] = API_KEY

        client["http://api.themoviedb.org/3/movie/now_playing", params,
                object : JsonHttpResponseHandler(){

                    override fun onSuccess(statusCode: Int, headers: Headers, json: JSON){
                        progressBar.hide()

                        val resultsRawJSON : String = json.jsonObject.get("results").toString()
                        val gson = Gson()
                        val arrayTutorialType = object : TypeToken<List<FlixsterMovie>>() {}.type
                        val models : List<FlixsterMovie> = gson.fromJson(resultsRawJSON, arrayTutorialType)
                        movieListRecyclerView.adapter = FlixsterMoviesRecyclerViewAdapter(models,this@FlixsterMoviesFragment)

                        Log.d("FlixsterMoviesFragment",models.get(0).moviePosterURL.toString())
                        Log.d("FlixsterMoviesFragment", "response successful")
                    }


                    override fun onFailure( statusCode: Int, headers: Headers?, errorResponse: String, t: Throwable?){
                        progressBar.hide()

                        Toast.makeText(requireContext(), "Failed to fetch movies. Please check your internet connection.", Toast.LENGTH_LONG).show()

                        t?.message?.let{
                            Log.e("FlixsterMoviesFragment", "HTML Error Code: " + statusCode.toString() + ", Headers: " + headers.toString())
                            Log.e("NowPlayingFragment", errorResponse)
                        }
                    }

                }]
    }




    override fun onItemClick(movie: FlixsterMovie) {
        Toast.makeText(requireContext(), "THe movie clicked: " + movie.title, Toast.LENGTH_LONG).show()
    }


}