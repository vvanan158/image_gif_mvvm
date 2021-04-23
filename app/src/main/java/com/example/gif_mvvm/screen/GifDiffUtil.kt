package com.example.gif_mvvm.screen

import androidx.recyclerview.widget.DiffUtil
import com.example.gif_mvvm.data.model.Gif

class GifDiffUtil : DiffUtil.ItemCallback<Gif>() {

    override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean {
        return oldItem == newItem
    }
}
