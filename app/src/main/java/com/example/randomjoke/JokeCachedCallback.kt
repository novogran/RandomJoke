package com.example.randomjoke

interface JokeCachedCallback {

    fun provide(jokeServerModel:JokeServerModel)

    fun fail()
}