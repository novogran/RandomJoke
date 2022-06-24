package com.example.randomjoke

class BaseJokeUiModel(text: String, punchline: String): JokeUiModel(text,punchline) {
    override fun getIconResId() = R.drawable.baseline_favorite_border_24
}