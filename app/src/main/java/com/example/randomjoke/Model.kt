package com.example.randomjoke

interface Model {

    fun getJoke()

    fun init(callback: ResultCallback)

    fun clear()
}