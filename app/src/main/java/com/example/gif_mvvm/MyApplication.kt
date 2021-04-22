package com.example.gif_mvvm

import android.app.Application
import com.example.gif_mvvm.module.apiModule
import com.example.gif_mvvm.module.repositoryModule
import com.example.gif_mvvm.module.retrofitModule
import com.example.gif_mvvm.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    apiModule,
                    retrofitModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}
