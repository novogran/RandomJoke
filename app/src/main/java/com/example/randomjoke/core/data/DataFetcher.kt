package com.example.randomjoke.core.data

import com.example.randomjoke.data.CommonDataModel

interface DataFetcher {
    suspend fun getData(): CommonDataModel
}