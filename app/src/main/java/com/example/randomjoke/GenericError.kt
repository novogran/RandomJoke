package com.example.randomjoke

import com.example.randomjoke.core.ResourceManager
import com.example.randomjoke.presentation.BaseFailure

class GenericError(private val resourceManager: ResourceManager): BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.generic_fail_message
}