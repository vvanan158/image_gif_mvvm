package com.example.gif_mvvm.module

import com.example.gif_mvvm.screen.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
