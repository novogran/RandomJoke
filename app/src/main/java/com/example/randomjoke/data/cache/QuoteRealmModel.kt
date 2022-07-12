package com.example.randomjoke.data.cache

import com.example.randomjoke.data.CommonDataModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class QuoteRealmModel: RealmObject() {
    @PrimaryKey
    var id: String = ""
    var content: String = ""
    var author: String = ""
    fun to() = CommonDataModel(id,content,author,true)
}