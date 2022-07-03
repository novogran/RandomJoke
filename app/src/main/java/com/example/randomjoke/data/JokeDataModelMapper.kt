package com.example.randomjoke

import com.example.randomjoke.data.JokeRealmModel
import com.example.randomjoke.domain.Joke

interface JokeDataModelMapper<T> {
    fun map (id: Int, text: String, punchline: String, cached: Boolean): T
}

class JokeSuccessMapper: JokeDataModelMapper<Joke.Success> {
    override fun map(id: Int, text: String, punchline: String, cached: Boolean) =
        Joke.Success(text,punchline,cached)
}

class JokeRealmMapper : JokeDataModelMapper<JokeRealmModel> {
    override fun map(id: Int, text: String, punchline: String, cached: Boolean) =
        JokeRealmModel().also { joke ->
            joke.id = id
            joke.text = text
            joke.punchline = punchline
        }
}