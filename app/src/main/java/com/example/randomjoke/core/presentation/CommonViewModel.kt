package com.example.randomjoke.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.randomjoke.presentation.CommonUiModel
import com.example.randomjoke.presentation.State

interface CommonViewModel<T> {
    fun getItem()
    fun getItemList()
    fun changeItemStatus(id:T)
    fun chooseFavorites(favorites: Boolean)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>)
}