package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.data.mapper.JokeRealmMapper

class JokeCachedDataSource(
    realmProvider: RealmProvider,
    mapper: JokeRealmMapper,
    commonDataMapper: JokeRealmToCommonMapper
):
    BaseCachedDataSource<JokeRealmModel>(realmProvider,mapper, commonDataMapper){
    override val dbClass = JokeRealmModel::class.java
}