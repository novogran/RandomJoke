package com.example.randomjoke.data.net

import com.example.randomjoke.core.Mapper
import com.example.randomjoke.data.CommonDataModel
import com.google.gson.annotations.SerializedName

class QuoteServerModel(
    @SerializedName("id")
    private val id: String,
    @SerializedName("content")
    private val content: String,
    @SerializedName("author")
    private val author: String
): Mapper<CommonDataModel> {
    override fun to() = CommonDataModel(System.currentTimeMillis().toInt(), content,author)
}