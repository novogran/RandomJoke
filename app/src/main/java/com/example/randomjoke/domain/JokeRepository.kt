package com.example.randomjoke.domain

import com.example.randomjoke.data.JokeDataModel

interface JokeRepository {

    suspend fun getJoke() : JokeDataModel

    suspend fun changeJokeStatus(): JokeDataModel

    fun chooseDataSource(cached: Boolean)
}