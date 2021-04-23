package com.example.gif_mvvm.screen

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.gif_mvvm.BR
import com.example.gif_mvvm.data.model.Gif

class GifItemViewModel : BaseObservable() {

    @Bindable
    var gif: Gif? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.gif)
        }
}
