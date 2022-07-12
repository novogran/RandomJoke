package com.example.randomjoke

import com.example.randomjoke.data.net.BaseCloudDataSource
import com.example.randomjoke.data.net.NewJokeService

class NewCloudDataSource(private val service: NewJokeService):
    BaseCloudDataSource<NewJokeServerModel,Int>(){
    override fun getServerModel() = service.getJoke()
}