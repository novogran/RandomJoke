package com.example.randomjoke.data

class NewCloudDataSource(private val service: NewJokeService):
    BaseCloudDataSource<NewJokeServerModel>(){
    override fun getServerModel() = service.getJoke()
}