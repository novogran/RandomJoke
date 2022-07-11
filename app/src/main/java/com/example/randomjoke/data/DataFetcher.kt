package com.example.randomjoke.data

interface DataFetcher {
    suspend fun getData(): CommonDataModel
}