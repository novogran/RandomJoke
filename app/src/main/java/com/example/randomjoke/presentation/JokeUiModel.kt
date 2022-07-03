package com.example.randomjoke.presentation

import androidx.annotation.DrawableRes

abstract class JokeUiModel(private val text: String, private val punchline: String) {

    protected open fun text() = "$text\n$punchline"

    @DrawableRes
    abstract fun getIconResId(): Int

    open fun show(communication: Communication) = communication.showState(
        State.Initial(text(), getIconResId())
    )
}