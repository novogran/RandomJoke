package com.example.randomjoke.domain

import com.example.randomjoke.data.CommonDataModel

interface CommonRepository {

    suspend fun getCommonItem() : CommonDataModel

    suspend fun changeStatus(): CommonDataModel

    fun chooseDataSource(cached: Boolean)
}