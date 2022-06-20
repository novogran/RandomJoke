package com.example.randomjoke

class FavoriteJoke(text: String, punchline: String): Joke(text,punchline) {
    override fun getIconResId() = R.drawable.baseline_favorite_24
}