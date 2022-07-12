package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.data.mapper.JokeRealmMapper
import io.realm.Realm

class JokeCachedDataSource(
    realmProvider: RealmProvider,
    mapper: JokeRealmMapper,
    commonDataMapper: JokeRealmToCommonMapper
):
    BaseCachedDataSource<JokeRealmModel, Int>(realmProvider,mapper, commonDataMapper){
    override val dbClass = JokeRealmModel::class.java
    override fun findRealmObject(realm: Realm, id: Int) =
        realm.where(dbClass).equalTo("id",id).findFirst()
    }