package com.example.gif_mvvm.data.model

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val image: Image,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: User
)
