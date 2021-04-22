package com.example.gif_mvvm.data.repository

import com.example.gif_mvvm.data.source.remote.GifApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GifRepository(private val gifApi: GifApi) {

    suspend fun getTrending(offset: Int) = withContext(Dispatchers.IO) {
        return@withContext gifApi.getTrending(offset = offset)
    }
}
