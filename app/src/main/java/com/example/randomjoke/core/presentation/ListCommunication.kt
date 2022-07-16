package com.example.randomjoke.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.randomjoke.presentation.CommonUiModel

interface ListCommunication<T> {

    fun getList() : List<CommonUiModel<T>>

    fun showDataList(list: List<CommonUiModel<T>>)

    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>)

    fun removeItem(id: T):Int
}