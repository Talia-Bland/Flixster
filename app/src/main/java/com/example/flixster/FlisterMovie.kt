package com.example.flixster

import com.google.gson.annotations.SerializedName

class FlisterMovie {
    @SerializedName("rank")
    var rank = 0

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("description")
    var description: String? = null

    //TODO bookImageUrl


    //TODO description


    //TODO-STRETCH-GOALS amazonUrl
}