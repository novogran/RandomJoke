package com.example.randomjoke

interface CloudDataSource {
    suspend fun getJoke(): Result<JokeServerModel,ErrorType>
}