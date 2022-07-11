package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.cache.RealmProvider
import io.realm.Realm

class BaseRealmProvide: RealmProvider {
    override fun provide(): Realm = Realm.getDefaultInstance()

}