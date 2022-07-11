package com.example.randomjoke.data

import com.example.randomjoke.core.Mapper
import com.google.gson.annotations.SerializedName

class NewJokeServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("setup")
    private val text: String,
    @SerializedName("delivery")
    private val punchline: String
): Mapper<CommonDataModel> {
    override fun to() = CommonDataModel(id,text,punchline)
}