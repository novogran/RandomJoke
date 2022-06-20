package com.example.randomjoke

class FailedJoke(text: String): Joke(text, "") {
    override fun getIconResId() = 0
}