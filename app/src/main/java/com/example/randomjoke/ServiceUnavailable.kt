package com.example.randomjoke

class ServiceUnavailable(private val resourceManager: ResourceManager): JokeFailure {
    override fun getMessage() = resourceManager.getString(R.string.service_unavailable)
}