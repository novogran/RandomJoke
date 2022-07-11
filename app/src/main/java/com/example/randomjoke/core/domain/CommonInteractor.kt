package com.example.randomjoke.core.domain

import com.example.randomjoke.domain.CommonItem

interface CommonInteractor {

    suspend fun getJoke(): CommonItem

    suspend fun changeFavorites(): CommonItem

    fun getFavorites(favorites:Boolean)
}