package com.example.gif_mvvm.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")
    val name: String = "",
    @SerializedName("avatar_url")
    val avatarUrl: String = ""
)
