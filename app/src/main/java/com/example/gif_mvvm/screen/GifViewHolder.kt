package com.example.gif_mvvm.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gif_mvvm.R
import com.example.gif_mvvm.data.model.Gif
import com.example.gif_mvvm.databinding.ItemLayoutGifBinding

class GifViewHolder(
    private val binding: ItemLayoutGifBinding,
    private var itemViewModel: GifItemViewModel = GifItemViewModel()
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.viewModel = itemViewModel
    }

    fun onBind(gif: Gif) {
        itemViewModel.gif = gif
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GifViewHolder {
            val binding = DataBindingUtil.inflate<ItemLayoutGifBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_layout_gif, parent,
                false
            )
            return GifViewHolder(binding)
        }
    }
}
