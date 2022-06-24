package com.example.randomjoke

interface JokeCloudCallback {

    fun provide(joke: Joke)

    fun fail(error:ErrorType)
}