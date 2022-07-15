package com.example.randomjoke.presentation

import androidx.lifecycle.*
import com.example.randomjoke.core.domain.CommonInteractor
import com.example.randomjoke.core.presentation.CommonCommunication
import com.example.randomjoke.core.presentation.CommonViewModel
import com.example.randomjoke.domain.CommonItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel<T>(
    private val interactor: CommonInteractor,
    private val communication: CommonCommunication<T>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
    ): ViewModel(), CommonViewModel<T> {

    override fun getItem() {
        viewModelScope.launch(dispatcher) {
            communication.showState(State.Progress)
            interactor.getItem().to().show(communication)
        }
    }

    override fun getItemList() {
        viewModelScope.launch(dispatcher) {
            communication.showDataList(interactor.getItemList().toUiList())
        }
    }

    override fun changeItemStatus(id:T) {
        communication.removeItem(id)
        viewModelScope.launch(dispatcher) {
            interactor.removeItem(id)
            if (communication.isState(State.INITIAL))
                interactor.changeFavorites().to().show(communication)
                communication.showDataList(interactor.getItemList().toUiList())
        }
    }

    override fun chooseFavorites(favorites: Boolean) = interactor.getFavorites(favorites)

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) =
        communication.observe(owner, observer)

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>) {
        communication.observeList(owner,observer)
    }

    fun List<CommonItem<T>>.toUiList() = map{it.to()}
}