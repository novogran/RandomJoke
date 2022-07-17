package com.example.randomjoke.presentation

import com.example.randomjoke.CommonDataRecyclerAdapter
import com.example.randomjoke.R

class FavoriteCommonUiModel<E>(private val id:E,text: String, punchline: String):
    CommonUiModel<E>(text,punchline) {

    override fun change(listener: CommonDataRecyclerAdapter.FavoriteItemClickListener<E>) =
        listener.change(id)

    override fun getIconResId() = R.drawable.baseline_favorite_24

    override fun matches(id: E): Boolean = this.id == id

    override fun same(model: CommonUiModel<E>): Boolean {
        return model is FavoriteCommonUiModel<E> && model.id == id
    }
}