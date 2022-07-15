package com.example.randomjoke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.randomjoke.core.presentation.CommonCommunication
import com.example.randomjoke.core.presentation.Communication

class BaseCommunication: CommonCommunication {
    private val liveData = MutableLiveData<State>()

    override fun showState(state: State) {
        liveData.value = state
    }

    private val listLiveData = MutableLiveData<List<CommonUiModel>>()

    override fun showDataList(list: List<CommonUiModel>) {
        listLiveData.value = list
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
        liveData.observe(owner,observer)
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel>>){
        listLiveData.observe(owner,observer)
    }

    override fun isState(type: Int) =
        liveData.value?.isType(type)?: false
}