package com.example.randomjoke.core.data

import com.example.randomjoke.data.CommonDataModel

interface CommonRepository {

    suspend fun getCommonItem() : CommonDataModel

    suspend fun changeStatus(): CommonDataModel

    fun chooseDataSource(cached: Boolean)
}