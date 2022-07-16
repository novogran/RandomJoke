package com.example.randomjoke.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.randomjoke.CommonDataRecyclerAdapter
import com.example.randomjoke.R
import com.example.randomjoke.data.CommonDataModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CommonDataRecyclerAdapter<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as JokeApp).viewModel
        val jokeCommunication = (application as JokeApp).jokeCommunication
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
        val observer: (t:List<CommonUiModel<Int>>) -> Unit = { _ ->
            adapter.update()
        }
        adapter = CommonDataRecyclerAdapter(object :
            CommonDataRecyclerAdapter.FavoriteItemClickListener<Int>{
            override fun change(id: Int) {
                Snackbar.make(
                    favoriteDataView,
                    R.string.remove_from_favorites,
                    Snackbar.LENGTH_SHORT
                ).setAction(R.string.yes){
                    val position = viewModel.changeItemStatus(id)
                    adapter.update(Pair(false,position))
                }.show()
            }
        }, jokeCommunication)
        recycleView.adapter = adapter
        viewModel.observeList(this,observer)
        viewModel.getItemList()
    }
}