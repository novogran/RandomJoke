package com.example.randomjoke

import com.example.randomjoke.data.JokeRealmModel
import com.example.randomjoke.domain.CommonItem

interface CommonDataModelMapper<T> {
    fun map (id: Int, first: String, second: String, cached: Boolean): T
}

class CommonSuccessMapper: CommonDataModelMapper<CommonItem.Success> {
    override fun map(id: Int, first: String, second: String, cached: Boolean) =
        CommonItem.Success(first,second,cached)
}

class CommonRealmMapper : CommonDataModelMapper<JokeRealmModel> {
    override fun map(id: Int, first: String, second: String, cached: Boolean) =
        JokeRealmModel().also { joke ->
            joke.id = id
            joke.text = first
            joke.punchline = second
        }
}