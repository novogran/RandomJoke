package com.example.randomjoke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.randomjoke.CommonDiffUtilCallback
import com.example.randomjoke.core.presentation.CommonCommunication
import com.example.randomjoke.core.presentation.Communication

class BaseCommunication<T>: CommonCommunication<T> {

    private lateinit var diffResult: DiffUtil.DiffResult
    private val liveData = MutableLiveData<State>()

    override fun getDiffResult() = diffResult

    override fun showState(state: State) {
        liveData.value = state
    }

    private val listLiveData = MutableLiveData<ArrayList<CommonUiModel<T>>>()

    override fun showDataList(list: List<CommonUiModel<T>>) {
        val callback = CommonDiffUtilCallback(listLiveData.value?: emptyList(),list)
        diffResult = DiffUtil.calculateDiff(callback)
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

    override fun getList(): List<CommonUiModel<T>> {
        return listLiveData.value?: emptyList()
    }
}