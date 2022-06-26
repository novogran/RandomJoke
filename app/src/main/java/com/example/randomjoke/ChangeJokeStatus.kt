package com.example.randomjoke

interface ChangeJokeStatus {
    suspend fun addOrRemove(id:Int, joke: Joke): JokeUiModel
}