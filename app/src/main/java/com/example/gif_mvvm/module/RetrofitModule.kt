package com.example.gif_mvvm.module

import com.example.gif_mvvm.data.source.remote.GifApi
import com.example.gif_mvvm.data.source.remote.RetrofitClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    fun provideApi(retrofit: RetrofitClient) = retrofit.create(GifApi::class.java)

    single { provideApi(get()) }
}

val retrofitModule = module {

    fun provideGson() = GsonBuilder().create()

    fun provideGsonConverterFactory(factory: Gson) = GsonConverterFactory.create(factory)

    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    fun provideRetrofit(factory: GsonConverterFactory, client: OkHttpClient): RetrofitClient {
        return RetrofitClient(factory, client)
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideGsonConverterFactory(get()) }
    single { provideRetrofit(get(), get()) }
}
