package com.example.gif_mvvm.data.source.remote

import com.example.gif_mvvm.utils.Constant.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient(factory: GsonConverterFactory, client: OkHttpClient) {

    private var baseRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(factory)
        .client(client)
        .build()

    fun <T> create(service: Class<T>): T {
        return baseRetrofit.create(service)
    }
}
