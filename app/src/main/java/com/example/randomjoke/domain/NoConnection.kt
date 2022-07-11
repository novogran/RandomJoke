package com.example.randomjoke.domain

import com.example.randomjoke.R

class NoConnection(resourceManager: ResourceManager): BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.no_connection
}