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
): Mapper<CommonDataModel<String>> {
    override fun to() = CommonDataModel(id, content,author)
}