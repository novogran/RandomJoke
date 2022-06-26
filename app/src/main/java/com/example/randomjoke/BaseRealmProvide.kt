package com.example.randomjoke

import io.realm.Realm


class BaseRealmProvide: RealmProvider {
    override fun provide(): Realm = Realm.getDefaultInstance()

}