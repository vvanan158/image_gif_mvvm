package com.example.gif_mvvm.data.source.remote

import com.example.gif_mvvm.data.source.response.GifResponse
import com.example.gif_mvvm.utils.Constant.API_KEY
import com.example.gif_mvvm.utils.Constant.LIMIT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifApi {

    @GET("gifs/trending")
    suspend fun getTrending(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("limit") limit: Int = LIMIT,
        @Query("offset") offset: Int
    ): Response<GifResponse>
}
