package com.example.randomjoke.presentation

import androidx.annotation.StringRes
import com.example.randomjoke.core.ResourceManager
import com.example.randomjoke.core.presentation.Failure

abstract class BaseFailure(private val resourceManager: ResourceManager): Failure {
    @StringRes
    protected abstract fun getMessageResId(): Int

    override fun getMessage(): String =
        resourceManager.getString(getMessageResId())
}