package com.example.randomjoke

class FavoriteJokeUiModel(text: String, punchline: String): JokeUiModel(text,punchline) {
    override fun getIconResId() = R.drawable.baseline_favorite_24
}