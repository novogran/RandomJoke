package com.example.randomjoke

interface Model {

    fun getJoke()

    fun init(callback: JokeCallback)

    fun clear()

    fun changeJokeStatus(callback: JokeCallback)

    fun chooseDataSource(cached: Boolean)
}