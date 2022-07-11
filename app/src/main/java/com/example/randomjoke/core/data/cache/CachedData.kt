package com.example.randomjoke.core.data.cache

import com.example.randomjoke.core.data.ChangeCommonItem
import com.example.randomjoke.data.CommonDataModel

interface CachedData: ChangeCommonItem {
    fun save(data: CommonDataModel)
    fun clear()
}