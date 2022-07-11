package com.example.randomjoke.data

import com.example.randomjoke.core.data.CommonRepository
import com.example.randomjoke.core.data.DataFetcher
import com.example.randomjoke.core.data.cache.CacheDataSource
import com.example.randomjoke.core.data.cache.CachedData
import com.example.randomjoke.core.data.net.CloudDataSource
import com.example.randomjoke.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class BaseRepository(
    private val cacheDataSource: CacheDataSource,
    private val cloudDataSource: CloudDataSource,
    private val cached: CachedData
): CommonRepository {

    private var currentDataSource: DataFetcher = cloudDataSource

    override fun chooseDataSource(cached: Boolean) {
        currentDataSource = if(cached) cacheDataSource else cloudDataSource
    }

    override suspend fun getCommonItem(): CommonDataModel =
        withContext(Dispatchers.IO) {
        try {
            val data = currentDataSource.getData()
            cached.save(data)
            return@withContext data
        } catch (e: Exception){
            throw e
        }
    }

    override suspend fun changeStatus(): CommonDataModel =
        cached.change(cacheDataSource)
}