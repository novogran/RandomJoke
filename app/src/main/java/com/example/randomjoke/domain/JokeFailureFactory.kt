package com.example.randomjoke.domain


class JokeFailureFactory(private val resourceManager: ResourceManager): JokeFailureHandler {
    override fun handle(e: Exception) =
        when (e){
            is NoConnectionException -> NoConnection(resourceManager)
            is NoCachedJokesException -> NoCachedJokes(resourceManager)
            is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
            else -> GenericError(resourceManager)
        }
    }
