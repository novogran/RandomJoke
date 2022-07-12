package com.example.randomjoke.core.data

import com.example.randomjoke.data.CommonDataModel

interface DataFetcher<E> {
    suspend fun getData(): CommonDataModel<E>
}