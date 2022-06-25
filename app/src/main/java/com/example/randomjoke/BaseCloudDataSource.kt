package com.example.randomjoke

import java.lang.Exception
import java.net.UnknownHostException

class BaseCloudDataSource(private val service: JokeService): CloudDataSource {
    override suspend fun getJoke(): Result<JokeServerModel, ErrorType> {
        return try{
            val result: JokeServerModel = service.getJoke().execute().body()!!
            Result.Success(result)
        } catch (e:Exception){
            val errorType = if(e is UnknownHostException)
                ErrorType.NO_CONNECTION
            else
                ErrorType.SERVICE_UNAVAILABLE
            Result.Error(errorType)
        }
    }

}