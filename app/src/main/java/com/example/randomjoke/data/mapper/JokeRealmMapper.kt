package com.example.randomjoke.data.mapper

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.data.cache.JokeRealmModel

class JokeRealmMapper : CommonDataModelMapper<JokeRealmModel> {
    override fun map(id: Int, first: String, second: String, cached: Boolean) =
        JokeRealmModel().also { joke ->
            joke.id = id
            joke.text = first
            joke.punchline = second
        }
}