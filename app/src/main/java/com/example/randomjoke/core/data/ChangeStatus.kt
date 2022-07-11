package com.example.randomjoke.core.data

import com.example.randomjoke.data.CommonDataModel

interface ChangeStatus {
    suspend fun addOrRemove(id:Int, model: CommonDataModel): CommonDataModel
}