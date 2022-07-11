package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.cache.RealmToCommonDataMapper
import com.example.randomjoke.data.CommonDataModel

class JokeRealmToCommonMapper : RealmToCommonDataMapper<JokeRealmModel> {
    override fun map(realmObject: JokeRealmModel) = CommonDataModel(realmObject.id, realmObject.text, realmObject.punchline, true)
}