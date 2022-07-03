package com.example.randomjoke.domain

interface JokeInteractor {

    suspend fun getJoke(): Joke

    suspend fun changeFavorites(): Joke

    fun getFavorites(favorites:Boolean)
}