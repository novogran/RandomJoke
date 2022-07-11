package com.example.randomjoke.data

import com.example.randomjoke.core.Mapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class JokeRealmModel: RealmObject(),Mapper<CommonDataModel> {

    @PrimaryKey
    var id: Int = -1
    var text: String = ""
    var punchline: String = ""

    override fun to() = CommonDataModel(id, text, punchline, true)
}