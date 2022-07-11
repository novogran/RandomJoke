package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.data.mapper.QuoteRealmMapper

class QuoteCachedDataSource(
    realmProvider: RealmProvider,
    mapper: QuoteRealmMapper,
    commonDataMapper: QuoteRealmToCommonMapper
) :
    BaseCachedDataSource<QuoteRealmModel>(realmProvider,mapper,commonDataMapper) {
    override val dbClass = QuoteRealmModel::class.java
}