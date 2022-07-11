package com.example.randomjoke.data

import com.example.randomjoke.core.Mapper
import retrofit2.Call
import retrofit2.http.GET

interface JokeService<T: Mapper<CommonDataModel>> {
     fun getJoke(): Call<T>
}

interface NewJokeService {
    @GET("https://v2.jokeapi.dev/joke/Any")
    fun getJoke(): Call<NewJokeServerModel>
}

interface BaseJokeService{
    @GET("https://official-joke-api.appspot.com/random_joke/")
    fun getJoke() : Call<JokeServerModel>
}