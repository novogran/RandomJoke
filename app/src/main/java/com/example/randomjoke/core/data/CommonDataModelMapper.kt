package com.example.randomjoke.core.data

import com.example.randomjoke.data.cache.JokeRealmModel
import com.example.randomjoke.data.cache.QuoteRealmModel
import com.example.randomjoke.domain.CommonItem

interface CommonDataModelMapper<T> {
    fun map (id: Int, first: String, second: String, cached: Boolean): T
}