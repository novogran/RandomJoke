package com.example.randomjoke

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class JokeRealm: RealmObject() {

    @PrimaryKey
    var id: Int = -1
    var type: String = ""
    var text: String = ""
    var punchline: String = ""

}