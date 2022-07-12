package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.ChangeCommonItem
import com.example.randomjoke.core.data.ChangeStatus
import com.example.randomjoke.core.data.cache.CachedData
import com.example.randomjoke.data.CommonDataModel

class BaseCachedData<E>: CachedData<E> {
    private var cached: ChangeCommonItem<E> = ChangeCommonItem.Empty()
    override fun save(data: CommonDataModel<E>) {
        cached = data
    }

    override fun clear() {
        cached = ChangeCommonItem.Empty()
    }

    override suspend fun change(changeStatus: ChangeStatus<E>): CommonDataModel<E> {
        return cached.change(changeStatus)
    }
}