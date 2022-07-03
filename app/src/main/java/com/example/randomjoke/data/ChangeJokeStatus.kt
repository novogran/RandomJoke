package com.example.randomjoke.data

interface ChangeJokeStatus {
    suspend fun addOrRemove(id:Int, joke: JokeDataModel): JokeDataModel
}