package com.example.randomjoke.presentation

class FailedJokeUiModel(private val text: String): JokeUiModel(text, "") {
    override fun text() = text
    override fun getIconResId() = 0
    override fun show(communication: Communication)  =
        communication.showState(
            State.Failed(text(),getIconResId())
        )
}