package com.example.randomjoke

interface CacheDataSource {

    suspend fun addOrRemove(id:Int, joke: Joke): JokeUiModel

    suspend fun getJoke(): Result<Joke, Unit>

}