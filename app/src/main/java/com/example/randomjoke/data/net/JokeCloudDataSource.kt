package com.example.randomjoke.data.net

class JokeCloudDataSource(private val service: BaseJokeService):
    BaseCloudDataSource<JokeServerModel>(){
    override fun getServerModel() = service.getJoke()
}