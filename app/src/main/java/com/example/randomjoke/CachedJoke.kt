package com.example.randomjoke

interface CachedJoke:ChangeJoke {
    fun saveJoke(joke: Joke)
    fun clear()
}