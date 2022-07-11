package com.example.randomjoke.presentation

import com.example.randomjoke.R

class FavoriteCommonUiModel(text: String, punchline: String): CommonUiModel(text,punchline) {
    override fun getIconResId() = R.drawable.baseline_favorite_24
}