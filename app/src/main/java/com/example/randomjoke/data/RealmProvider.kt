package com.example.randomjoke.data

import io.realm.Realm

interface RealmProvider {

    fun provide(): Realm
}