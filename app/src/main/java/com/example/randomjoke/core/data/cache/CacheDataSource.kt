package com.example.randomjoke.core.data.cache

import com.example.randomjoke.core.data.ChangeStatus
import com.example.randomjoke.core.data.DataFetcher
import com.example.randomjoke.data.CommonDataModel

interface CacheDataSource<E>: DataFetcher<E>, ChangeStatus<E>{
    suspend fun getDataList(): List<CommonDataModel<E>>
    suspend fun remove(id:E)
}