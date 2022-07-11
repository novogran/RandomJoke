package com.example.randomjoke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.randomjoke.core.presentation.Communication

class BaseCommunication: Communication {
    private val liveData = MutableLiveData<State>()

    override fun showState(state: State) {
        liveData.value = state
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
        liveData.observe(owner,observer)
    }

    override fun isState(type: Int) =
        liveData.value?.isType(type)?: false
}