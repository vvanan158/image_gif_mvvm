package com.example.gif_mvvm.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("data")
fun <T> bindDataRecyclerView(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindingDataRecyclerView<*>) {
        (recyclerView.adapter as BindingDataRecyclerView<T>).setData(data)
    }
}

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

@BindingAdapter(value = ["isLoad", "onLoadMore"])
fun RecyclerView.onScrollListener(
    isLoad: Boolean,
    loadMoreListener: LoadMoreRecyclerViewListener
) {
    clearOnScrollListeners()
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0) {
                (recyclerView.layoutManager as GridLayoutManager).run {
                    if (isLoad) {
                        if ((childCount + findFirstVisibleItemPosition()) >= itemCount) {
                            loadMoreListener.onLoadData()
                        }
                    }
                }
            }
        }
    })
}

@BindingAdapter(value = ["image"])
fun AppCompatImageView.bindImageViewHolder(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}
