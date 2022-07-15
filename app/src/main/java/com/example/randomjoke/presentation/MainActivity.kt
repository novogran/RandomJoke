package com.example.randomjoke.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.randomjoke.CommonDataRecyclerAdapter
import com.example.randomjoke.R
import com.example.randomjoke.data.CommonDataModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as JokeApp).viewModel
        val favoriteDataView = findViewById<FavoriteDataView>(R.id.jokeFavoriteDataView)
        favoriteDataView.linkWith(viewModel)
        viewModel.observe(this) { state ->
           favoriteDataView.show(state)
        }

        val quoteViewModel = (application as JokeApp).quoteViewModel
        val quoteFavoriteDataView = findViewById<FavoriteDataView>(R.id.quoteFavoriteDataView)
        quoteFavoriteDataView.linkWith(quoteViewModel)
        quoteViewModel.observe(this) { state ->
            quoteFavoriteDataView.show(state)
        }

        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        val adapter = CommonDataRecyclerAdapter<Int>()
        recycleView.adapter = adapter
        viewModel.observeList(this) { list ->
            adapter.show(list)
        }
        viewModel.getItemList()
    }
}