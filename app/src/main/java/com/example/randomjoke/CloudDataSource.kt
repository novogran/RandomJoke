package com.example.randomjoke

interface CloudDataSource {
    fun getJoke(callback: JokeCloudCallback)
}