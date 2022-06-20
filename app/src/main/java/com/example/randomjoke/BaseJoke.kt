package com.example.randomjoke

class BaseJoke(text: String, punchline: String): Joke(text,punchline) {
    override fun getIconResId() = R.drawable.baseline_favorite_border_24
}