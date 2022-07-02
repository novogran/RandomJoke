package com.example.randomjoke

class FailedJokeUiModel(private val text: String): JokeUiModel(text, "") {
    override fun text() = text
    override fun getIconResId() = 0
}