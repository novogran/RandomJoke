package com.example.randomjoke

import com.google.gson.annotations.SerializedName

data class JokeDTO (
    @SerializedName("id")
    private val id: Int,
    @SerializedName("type")
    private val  type: String,
    @SerializedName("setup")
    private val  text: String,
    @SerializedName("punchline")
    private val  punchline: String,
        ) {
    fun toJoke() = Joke(text,punchline)
}