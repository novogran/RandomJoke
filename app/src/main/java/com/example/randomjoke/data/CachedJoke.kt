package com.example.randomjoke.data

interface CachedJoke: ChangeJoke {
    fun saveJoke(joke: JokeDataModel)
    fun clear()
}