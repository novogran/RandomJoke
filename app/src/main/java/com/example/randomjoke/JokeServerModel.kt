package com.example.randomjoke

import com.google.gson.annotations.SerializedName

data class JokeServerModel (
    @SerializedName("id")
    private val id: Int,
    @SerializedName("type")
    private val  type: String,
    @SerializedName("setup")
    private val  text: String,
    @SerializedName("punchline")
    private val  punchline: String,
        ) {
    fun toBaseJoke() = BaseJokeUiModel(text,punchline)

    fun toFavoriteJoke() = FavoriteJokeUiModel(text,punchline)

    fun toJoke() = Joke(id, type, text, punchline)
}