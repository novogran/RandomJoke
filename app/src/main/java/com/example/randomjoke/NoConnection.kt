package com.example.randomjoke

class NoConnection(private val resourceManager: ResourceManager): JokeFailure {
    override fun getMessage() = resourceManager.getString(R.string.no_connection)
}