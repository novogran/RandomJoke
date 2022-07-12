package com.example.randomjoke.core.data.cache

import com.example.randomjoke.data.CommonDataModel
import io.realm.RealmObject

interface RealmToCommonDataMapper<T: RealmObject,E> {
    fun map(realmObject: T): CommonDataModel<E>
}
