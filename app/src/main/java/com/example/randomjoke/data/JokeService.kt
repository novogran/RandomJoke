package com.example.randomjoke.data

import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET("https://official-joke-api.appspot.com/random_joke/")
    fun getJoke() : Call<JokeServerModel>

    @GET("https://v2.jokeapi.dev/joke/Any")
    fun getNewJoke(): Call<NewJokeServerModel>

}