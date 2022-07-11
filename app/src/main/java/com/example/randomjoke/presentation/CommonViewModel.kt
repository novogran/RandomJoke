package com.example.randomjoke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface CommonViewModel {
    fun getItem()
    fun changeItemStatus()
    fun chooseFavorites(favorites: Boolean)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
}