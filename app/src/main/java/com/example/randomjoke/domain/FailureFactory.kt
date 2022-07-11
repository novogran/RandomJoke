package com.example.randomjoke.domain


class FailureFactory(private val resourceManager: ResourceManager): FailureHandler {
    override fun handle(e: Exception) =
        when (e){
            is NoConnectionException -> NoConnection(resourceManager)
            is NoCachedJokesException -> NoCachedData(resourceManager)
            is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
            else -> GenericError(resourceManager)
        }
    }
