package com.example.randomjoke.data.mapper

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.data.cache.QuoteRealmModel

class QuoteRealmMapper: CommonDataModelMapper<QuoteRealmModel> {
    override fun map(id: Int, first: String, second: String, cached: Boolean) =
        QuoteRealmModel().also { quote ->
            quote.id = id
            quote.content = first
            quote.author = second
        }
}