package com.example.randomjoke.domain

import com.example.randomjoke.R

class GenericError(private val resourceManager: ResourceManager): BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.generic_fail_message
}