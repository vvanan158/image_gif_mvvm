package com.example.gif_mvvm.module

import com.example.gif_mvvm.data.repository.GifRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { GifRepository(get()) }
}
