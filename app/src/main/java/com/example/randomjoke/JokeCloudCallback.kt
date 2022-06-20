package com.example.randomjoke

interface JokeCloudCallback {

    fun provide(jokeServerModel:JokeServerModel)

    fun fail()
}