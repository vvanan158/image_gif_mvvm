package com.example.gif_mvvm.data.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("fixed_width")
    val detail: DetailImage,
)

data class DetailImage(
    @SerializedName("url")
    val url: String,
    @SerializedName("height")
    val height: Float,
    @SerializedName("width")
    val width: Float,
)
