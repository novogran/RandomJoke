package com.example.randomjoke.domain

import com.example.randomjoke.R

class NoCachedJokes(resourceManager: ResourceManager): BaseJokeFailure(resourceManager) {
    override fun getMessageResId() = R.string.no_cached_jokes
}