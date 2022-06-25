package com.example.randomjoke

class FailedJokeUiModel(text: String): JokeUiModel(text, "") {
    override fun getIconResId() = 0
}