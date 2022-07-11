package com.example.randomjoke.core.data.cache

import io.realm.Realm

interface RealmProvider {

    fun provide(): Realm
}