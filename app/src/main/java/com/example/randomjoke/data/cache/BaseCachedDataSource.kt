package com.example.randomjoke.data.cache

import com.example.randomjoke.core.data.CommonDataModelMapper
import com.example.randomjoke.core.data.cache.CacheDataSource
import com.example.randomjoke.core.data.cache.RealmProvider
import com.example.randomjoke.core.data.cache.RealmToCommonDataMapper
import com.example.randomjoke.core.domain.NoCachedDataException
import com.example.randomjoke.data.CommonDataModel
import io.realm.RealmObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseCachedDataSource<T: RealmObject>(
    private val realmProvider: RealmProvider,
    private val mapper: CommonDataModelMapper<T>,
    private val realmToCommonDataMapper: RealmToCommonDataMapper<T>
): CacheDataSource {

    protected abstract val dbClass: Class<T>
    
    override suspend fun addOrRemove(id: Int, model: CommonDataModel): CommonDataModel =
        withContext(Dispatchers.IO) {
            realmProvider.provide().use{
                val itemRealm =
                    it.where(dbClass).equalTo("id",id).findFirst()
                return@withContext if (itemRealm == null) {
                    it.executeTransaction { transaction ->
                        val newData = model.map(mapper)
                        transaction.insert(newData)
                    }
                    model.changeCached(true)
                } else {
                    it.executeTransaction {
                        itemRealm.deleteFromRealm()
                    }
                    model.changeCached(false)
                }
            }
    }

    override suspend fun getData(): CommonDataModel {
        realmProvider.provide().use {
            val list = it.where(dbClass).findAll()
            if(list.isEmpty())
                throw NoCachedDataException()
            else
                return realmToCommonDataMapper.map(list.random())
                }
        }
    }