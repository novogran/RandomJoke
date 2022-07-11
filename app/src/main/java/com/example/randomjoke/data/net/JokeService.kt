package com.example.randomjoke.data.net

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.data.CommonDataModel
import com.example.randomjoke.NewJokeServerModel
import retrofit2.Call
import retrofit2.http.GET

interface JokeService<T: Mapper<CommonDataModel>> {
     fun getJoke(): Call<T>
}

interface NewJokeService {
    @GET("https://v2.jokeapi.dev/joke/Any")
    fun getJoke(): Call<NewJokeServerModel>
}

interface BaseJokeService: JokeService<JokeServerModel>{
    @GET("https://official-joke-api.appspot.com/random_joke/")
    override fun getJoke() : Call<JokeServerModel>
}