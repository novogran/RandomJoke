package com.example.randomjoke.domain

interface CommonInteractor {

    suspend fun getJoke(): CommonItem

    suspend fun changeFavorites(): CommonItem

    fun getFavorites(favorites:Boolean)
}