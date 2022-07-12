package com.example.randomjoke

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.data.CommonDataModel
import com.google.gson.annotations.SerializedName

class NewJokeServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("setup")
    private val text: String,
    @SerializedName("delivery")
    private val punchline: String
): Mapper<CommonDataModel<Int>> {
    override fun to() = CommonDataModel(id,text,punchline)
}