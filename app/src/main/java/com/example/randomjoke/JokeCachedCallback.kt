package com.example.randomjoke

interface JokeCachedCallback {

    fun provide(joke: Joke)

    fun fail()
}