package com.example.randomjoke.data

class NewJokeCloudDataSource(private val service: NewJokeService):
    BaseCloudDataSource<NewJokeServerModel>(){
    override fun getJokeServerModel() = service.getJoke()
}