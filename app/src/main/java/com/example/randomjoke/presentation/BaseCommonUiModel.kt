package com.example.randomjoke.presentation

import com.example.randomjoke.R

class BaseCommonUiModel<E>(text: String, punchline: String): CommonUiModel<E>(text,punchline) {
    override fun getIconResId() = R.drawable.baseline_favorite_border_24
}