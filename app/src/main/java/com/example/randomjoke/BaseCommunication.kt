package com.example.randomjoke

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class BaseCommunication: Communication {
    private val liveData = MutableLiveData<BaseViewModel.State>()

    override fun showState(state: BaseViewModel.State) {
        liveData.value = state
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<BaseViewModel.State>) {
        liveData.observe(owner,observer)
    }
}