package com.example.randomjoke.data

interface JokeDataFetcher {
    suspend fun getJoke(): JokeDataModel
}