package com.example.randomjoke.core.data.cache

import com.example.randomjoke.data.CommonDataModel
import io.realm.RealmObject

interface RealmToCommonDataMapper<T: RealmObject> {
    fun map(realmObject: T): CommonDataModel
}
