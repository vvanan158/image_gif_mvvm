package com.example.gif_mvvm.screen

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gif_mvvm.data.model.Gif
import com.example.gif_mvvm.utils.BindingDataRecyclerView

class TrendingAdapter : ListAdapter<Gif, GifViewHolder>(GifDiffUtil()),
    BindingDataRecyclerView<MutableList<Gif>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun setData(data: MutableList<Gif>?) {
        data?.let {
            submitList(data.toMutableList())
        }
    }
}
