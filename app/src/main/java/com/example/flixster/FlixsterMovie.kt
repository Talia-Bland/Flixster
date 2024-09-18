package com.example.flixster

import com.google.gson.annotations.SerializedName

class FlixsterMovie {
    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("description")
    var description: String? = null

   @JvmField
   @SerializedName("movie_poster")
   var moviePosterURL: String? = null
}