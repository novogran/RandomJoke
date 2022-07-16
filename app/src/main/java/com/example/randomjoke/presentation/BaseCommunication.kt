package com.example.randomjoke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.randomjoke.core.presentation.CommonCommunication
import com.example.randomjoke.core.presentation.Communication

class BaseCommunication<T>: CommonCommunication<T> {
    private val liveData = MutableLiveData<State>()

    override fun showState(state: State) {
        liveData.value = state
    }

    private val listLiveData = MutableLiveData<ArrayList<CommonUiModel<T>>>()

    override fun showDataList(list: List<CommonUiModel<T>>) {
        listLiveData.value = ArrayList(list)
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
        liveData.observe(owner,observer)
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>){
        listLiveData.observe(owner,observer)
    }

    override fun isState(type: Int) =
        liveData.value?.isType(type)?: false

    override fun removeItem(id: T): Int {
        val found = listLiveData.value?.find {
            it.matches(id)
        }
        val position = listLiveData.value?.indexOf(found)?: -1
        found?.let {
            listLiveData.value?.remove(it)
        }
        return position
    }

    override fun getList(): List<CommonUiModel<T>> {
        return listLiveData.value?: emptyList()
    }
}