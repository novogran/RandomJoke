package com.example.randomjoke

import androidx.annotation.DrawableRes

abstract class JokeUiModel(private val text: String, private val punchline: String) {

    protected open fun text() = "$text\n$punchline"

    @DrawableRes
    abstract fun getIconResId(): Int

    fun show(communication: Communication) = communication.showState(
        BaseViewModel.State.Initial(text(), getIconResId())
    )
}