package com.example.randomjoke

interface CacheDataSource {

    fun addOrRemove(id:Int, jokeServerModel:JokeServerModel):Joke

    fun getJoke(jokeCachedCallback: JokeCachedCallback)

}