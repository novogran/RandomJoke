package com.example.randomjoke

import com.example.randomjoke.core.ResourceManager
import com.example.randomjoke.presentation.BaseFailure

class NoCachedData(resourceManager: ResourceManager): BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.no_cached_data
}