package com.example.randomjoke.core.data

import com.example.randomjoke.data.CommonDataModel

interface ChangeStatus<E> {
    suspend fun addOrRemove(id:E, model: CommonDataModel<E>): CommonDataModel<E>
}