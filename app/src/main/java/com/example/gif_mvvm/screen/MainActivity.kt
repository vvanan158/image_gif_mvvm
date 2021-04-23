package com.example.gif_mvvm.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.gif_mvvm.R
import com.example.gif_mvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()
    private lateinit var adapter: TrendingAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initViews()
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.fetchTrending()
    }

    private fun initData() {
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                lifecycleOwner = this@MainActivity
                viewModel = mainViewModel
            }
        adapter = TrendingAdapter()
    }

    private fun initViews() {
        binding.trendingAdapter = adapter
    }
}
