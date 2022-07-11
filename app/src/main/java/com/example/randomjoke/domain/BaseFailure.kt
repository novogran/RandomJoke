package com.example.randomjoke.domain

import androidx.annotation.StringRes

abstract class BaseFailure(private val resourceManager: ResourceManager): Failure {
    @StringRes
    protected abstract fun getMessageResId(): Int

    override fun getMessage(): String =
        resourceManager.getString(getMessageResId())
}