package com.example.randomjoke.core.data

import com.example.randomjoke.data.CommonDataModel

interface CommonRepository<E> {

    suspend fun getCommonItem() : CommonDataModel<E>

    suspend fun getCommonItemList(): List<CommonDataModel<E>>

    suspend fun changeStatus(): CommonDataModel<E>

    fun chooseDataSource(cached: Boolean)
}