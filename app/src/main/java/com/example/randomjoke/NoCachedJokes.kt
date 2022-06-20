package com.example.randomjoke

class NoCachedJokes(private val resourceManager: ResourceManager):JokeFailure {
    override fun getMessage() = resourceManager.getString(R.string.no_cached_jokes)
}