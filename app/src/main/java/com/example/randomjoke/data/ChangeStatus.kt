package com.example.randomjoke.data

interface ChangeStatus {
    suspend fun addOrRemove(id:Int, joke: CommonDataModel): CommonDataModel
}