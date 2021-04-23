package com.example.gif_mvvm.data.model

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("offset")
    val offset: Int
)
