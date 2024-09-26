package com.example.flixster

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val moviePosterURL = intent.getStringExtra("movie_poster_url")

        val movieTitleTextView: TextView = findViewById(R.id.movie_title_textview)
            val movieTitle = intent.getStringExtra("movie_title")
            movieTitleTextView.text = movieTitle
        val movieDescriptionTextView: TextView = findViewById(R.id.movie_description_textview)
            val movieDescription = intent.getStringExtra("movie_description")
            movieDescriptionTextView.text = movieDescription

        val moviePosterImageView: ImageView = findViewById(R.id.movie_poster_imageview)


        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+moviePosterURL)
            .fitCenter()
            .placeholder(R.drawable.placeholder_movieposter)
            .error(R.drawable.error_image)
            .into(moviePosterImageView)



    }
}