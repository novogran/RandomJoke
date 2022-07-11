package com.example.randomjoke

import com.example.randomjoke.core.ResourceManager
import com.example.randomjoke.presentation.BaseFailure

class ServiceUnavailable(resourceManager: ResourceManager): BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.service_unavailable
}