package com.example.randomjoke

abstract class BaseResultHandler<S,E>
    (private val jokeDataFetcher: JokeDataFetcher<S,E>){

    suspend fun process():JokeUiModel{
        return handleResult(jokeDataFetcher.getJoke())
    }

    protected abstract fun handleResult(result: Result<S, E>): JokeUiModel
}