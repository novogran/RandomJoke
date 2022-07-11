package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.ChangeCommonItem
import com.example.randomjoke.core.data.ChangeStatus
import com.example.randomjoke.core.data.cache.CachedData
import com.example.randomjoke.data.CommonDataModel

class BaseCachedData: CachedData {
    private var cached: ChangeCommonItem = ChangeCommonItem.Empty()
    override fun save(data: CommonDataModel) {
        cached = data
    }

    override fun clear() {
        cached = ChangeCommonItem.Empty()
    }

    override suspend fun change(changeStatus: ChangeStatus): CommonDataModel {
        return cached.change(changeStatus)
    }
}