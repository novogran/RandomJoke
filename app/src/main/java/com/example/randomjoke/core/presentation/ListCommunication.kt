package com.example.randomjoke.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.randomjoke.presentation.CommonUiModel

interface ListCommunication {

    fun showDataList(list: List<CommonUiModel>)

    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel>>)
}