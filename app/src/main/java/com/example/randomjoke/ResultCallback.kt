package com.example.randomjoke

interface ResultCallback {

    fun provideSuccess(data: Joke)

    fun provideError(error: JokeFailure)
}