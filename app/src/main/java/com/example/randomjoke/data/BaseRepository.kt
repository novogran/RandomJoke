package com.example.randomjoke.data

import com.example.randomjoke.core.data.CommonRepository
import com.example.randomjoke.core.data.DataFetcher
import com.example.randomjoke.core.data.cache.CacheDataSource
import com.example.randomjoke.core.data.cache.CachedData
import com.example.randomjoke.core.data.net.CloudDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class BaseRepository<E>(
    private val cacheDataSource: CacheDataSource<E>,
    private val cloudDataSource: CloudDataSource<E>,
    private val cached: CachedData<E>
): CommonRepository<E> {

    private var currentDataSource: DataFetcher<E> = cloudDataSource

    override fun chooseDataSource(cached: Boolean) {
        currentDataSource = if(cached) cacheDataSource else cloudDataSource
    }

    override suspend fun getCommonItem(): CommonDataModel<E> =
        withContext(Dispatchers.IO) {
        try {
            val data = currentDataSource.getData()
            cached.save(data)
            return@withContext data
        } catch (e: Exception){
            cached.clear()
            throw e
        }
    }

    override suspend fun getCommonItemList(): List<CommonDataModel<E>> = withContext(Dispatchers.IO) {
        cacheDataSource.getDataList()
    }

    override suspend fun changeStatus(): CommonDataModel<E> = cached.change(cacheDataSource)

    override suspend fun removeItem(id: E) {
        cacheDataSource.remove(id)
    }
}