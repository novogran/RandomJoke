package com.example.randomjoke

interface JokeDataFetcher<S,E> {
    suspend fun getJoke():Result<S,E>
}