package com.example.randomjoke

interface CacheDataSource {

    fun addOrRemove(id:Int, joke: Joke): JokeUiModel

    fun getJoke(jokeCachedCallback: JokeCachedCallback)

}