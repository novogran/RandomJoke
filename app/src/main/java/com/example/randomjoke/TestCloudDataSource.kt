package com.example.randomjoke

class TestCloudDataSource: CloudDataSource {
    private var count = 0
    override fun getJoke(callback: JokeCloudCallback) {
        val joke = Joke(count,"testType", "TestText$count", "TestPunchline$count")
        callback.provide(joke)
        count++
    }
}