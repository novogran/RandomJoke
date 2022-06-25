package com.example.randomjoke

interface Model {

    suspend fun getJoke() : JokeUiModel

    suspend fun changeJokeStatus(): JokeUiModel?

    fun chooseDataSource(cached: Boolean)
}