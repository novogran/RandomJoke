package com.example.randomjoke

import androidx.annotation.DrawableRes

abstract class JokeUiModel(private val text: String, private val punchline: String) {

    protected fun text() = "$text\n$punchline"

    @DrawableRes
    abstract fun getIconResId(): Int

    fun map(callback: DataCallback)  = callback.run {
        provideText(text())
        provideIconRes(getIconResId())
    }

}