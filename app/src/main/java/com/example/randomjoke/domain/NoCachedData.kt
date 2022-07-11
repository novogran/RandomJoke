package com.example.randomjoke.domain

import com.example.randomjoke.R

class NoCachedData(resourceManager: ResourceManager): BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.no_cached_data
}