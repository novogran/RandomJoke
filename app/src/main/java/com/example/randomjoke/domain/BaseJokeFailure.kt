package com.example.randomjoke.domain

import androidx.annotation.StringRes

abstract class BaseJokeFailure(private val resourceManager: ResourceManager): JokeFailure {
    @StringRes
    protected abstract fun getMessageResId(): Int

    override fun getMessage(): String =
        resourceManager.getString(getMessageResId())
}