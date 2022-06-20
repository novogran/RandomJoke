package com.example.randomjoke

import androidx.annotation.DrawableRes

abstract class Joke(private val text: String, private val punchline: String) {

    protected fun getJokeUi() = "$text\n$punchline"

    @DrawableRes
    abstract fun getIconResId(): Int

    fun map(callback: DataCallback)  = callback.run {
        provideText(getJokeUi())
        provideIconRes(getIconResId())
    }

}