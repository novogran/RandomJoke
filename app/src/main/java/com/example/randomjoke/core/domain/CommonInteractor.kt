package com.example.randomjoke.core.domain

import com.example.randomjoke.domain.CommonItem

interface CommonInteractor {

    suspend fun getItem(): CommonItem

    suspend fun getItemList(): List<CommonItem>

    suspend fun changeFavorites(): CommonItem

    fun getFavorites(favorites:Boolean)
}