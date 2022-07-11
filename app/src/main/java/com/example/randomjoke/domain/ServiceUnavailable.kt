package com.example.randomjoke.domain

import com.example.randomjoke.R

class ServiceUnavailable(resourceManager: ResourceManager): BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.service_unavailable
}