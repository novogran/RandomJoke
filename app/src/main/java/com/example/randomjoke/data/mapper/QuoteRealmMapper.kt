package com.example.randomjoke.data.mapper

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.data.cache.QuoteRealmModel

class QuoteRealmMapper: CommonDataModelMapper<QuoteRealmModel, String> {
    override fun map(id: String, first: String, second: String, cached: Boolean) =
        QuoteRealmModel().also { quote ->
            quote.id = id
            quote.content = first
            quote.author = second
        }
}