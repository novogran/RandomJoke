package com.example.randomjoke.presentation

import androidx.annotation.DrawableRes

abstract class CommonUiModel(private val first: String, private val second: String) {

    protected open fun text() = "$first\n$second"

    @DrawableRes
    abstract fun getIconResId(): Int

    open fun show(communication: Communication) = communication.showState(
        State.Initial(text(), getIconResId())
    )
}