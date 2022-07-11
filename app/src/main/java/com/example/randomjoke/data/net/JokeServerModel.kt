package com.example.randomjoke.data.net

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.data.CommonDataModel
import com.google.gson.annotations.SerializedName

data class JokeServerModel (
    @SerializedName("id")
    private val id: Int,
    @SerializedName("setup")
    private val  text: String,
    @SerializedName("punchline")
    private val  punchline: String,
        ): Mapper<CommonDataModel> {

    override fun to() = CommonDataModel(id, text, punchline)

}