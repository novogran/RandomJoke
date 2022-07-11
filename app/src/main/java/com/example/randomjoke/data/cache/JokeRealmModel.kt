package com.example.randomjoke.data.cache

import com.example.randomjoke.data.CommonDataModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class JokeRealmModel: RealmObject() {

    @PrimaryKey
    var id: Int = -1
    var text: String = ""
    var punchline: String = ""

    fun to() = CommonDataModel(id, text, punchline, true)
}