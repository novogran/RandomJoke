package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.cache.RealmToCommonDataMapper
import com.example.randomjoke.data.CommonDataModel

class QuoteRealmToCommonMapper : RealmToCommonDataMapper<QuoteRealmModel> {
    override fun map(realmObject: QuoteRealmModel) = CommonDataModel(realmObject.id, realmObject.content, realmObject.author, true)
}