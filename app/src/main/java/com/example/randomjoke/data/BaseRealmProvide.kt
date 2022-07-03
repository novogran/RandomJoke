package com.example.randomjoke.data

import com.example.randomjoke.data.RealmProvider
import io.realm.Realm


class BaseRealmProvide: RealmProvider {
    override fun provide(): Realm = Realm.getDefaultInstance()

}