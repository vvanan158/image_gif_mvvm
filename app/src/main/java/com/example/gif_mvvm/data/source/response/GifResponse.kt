package com.example.gif_mvvm.data.source.response

import com.example.gif_mvvm.data.model.Gif
import com.example.gif_mvvm.data.model.Pagination
import com.google.gson.annotations.SerializedName

data class GifResponse(
    @SerializedName("data")
    val gifs: MutableList<Gif>,
    @SerializedName("pagination")
    val pagination: Pagination
)
