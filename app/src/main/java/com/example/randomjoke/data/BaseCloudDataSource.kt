package com.example.randomjoke.data

import com.example.randomjoke.domain.NoConnectionException
import com.example.randomjoke.domain.ServiceUnavailableException
import java.lang.Exception
import java.net.UnknownHostException

class BaseCloudDataSource(private val service: JokeService): CloudDataSource {
    override suspend fun getJoke(): JokeDataModel {
        try {
            return service.getNewJoke().execute().body()!!.to()
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }
}