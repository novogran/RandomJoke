package com.example.randomjoke.core.data.cache

import com.example.randomjoke.core.data.ChangeCommonItem
import com.example.randomjoke.data.CommonDataModel

interface CachedData<E>: ChangeCommonItem<E> {
    fun save(data: CommonDataModel<E>)
    fun clear()
}