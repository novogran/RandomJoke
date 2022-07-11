package com.example.randomjoke.data

interface CachedData: ChangeCommonItem {
    fun save(data: CommonDataModel)
    fun clear()
}