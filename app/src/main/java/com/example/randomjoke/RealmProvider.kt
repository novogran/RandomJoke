package com.example.randomjoke

import io.realm.Realm

interface RealmProvider {

    fun provide(): Realm
}