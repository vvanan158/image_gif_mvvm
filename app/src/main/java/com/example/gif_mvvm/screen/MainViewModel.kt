package com.example.gif_mvvm.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gif_mvvm.data.model.Gif
import com.example.gif_mvvm.data.repository.GifRepository
import com.example.gif_mvvm.extensions.plusAssign
import com.example.gif_mvvm.utils.Constant
import com.example.gif_mvvm.utils.LoadMoreRecyclerViewListener
import kotlinx.coroutines.launch

open class MainViewModel(private val gifRepository: GifRepository) : ViewModel(),
    LoadMoreRecyclerViewListener {

    private var currentPosition = 0
    private val _isLoad = MutableLiveData<Boolean>()
    val isLoad: LiveData<Boolean>
        get() = _isLoad
    private val _gifs = MutableLiveData<MutableList<Gif>>()
    val gifs: LiveData<MutableList<Gif>>
        get() = _gifs

    fun fetchTrending(offset: Int = 0) {
        viewModelScope.launch {
            try {
                gifRepository.getTrending(offset).body()?.also {
                    _gifs.plusAssign(it.gifs)
                    currentPosition = it.pagination.offset + Constant.LIMIT
                    _isLoad.postValue(true)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onLoadData() {
        _isLoad.value = false
        fetchTrending(currentPosition)
    }
}
