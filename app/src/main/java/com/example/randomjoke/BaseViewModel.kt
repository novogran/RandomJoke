package com.example.randomjoke

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BaseViewModel(
    private val model: Model,
    private val communication: Communication
    ): ViewModel() {

    val liveData = MutableLiveData<Pair<String,Int>>()

    fun getJoke() = viewModelScope.launch{
        communication.showData(model.getJoke().getData())
    }

    fun chooseFavorites(favorites: Boolean) = model.chooseDataSource(favorites)

    fun changeJokeStatus() = viewModelScope.launch{
        model.changeJokeStatus()?.let {
           communication.showData(it.getData())
        }
    }

    fun observe(owner: LifecycleOwner,observer: Observer<Pair<String,Int>>) =
        communication.observe(owner,observer)
}