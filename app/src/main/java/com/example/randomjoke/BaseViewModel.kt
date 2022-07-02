package com.example.randomjoke

import androidx.annotation.DrawableRes
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseViewModel(
    private val model: Model,
    private val communication: Communication,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
    ): ViewModel() {

    fun getJoke() = viewModelScope.launch(dispatcher){
        communication.showState(State.Progress)
        model.getJoke().show(communication)
    }

    fun chooseFavorites(favorites: Boolean) = model.chooseDataSource(favorites)

    fun changeJokeStatus() = viewModelScope.launch(dispatcher){
        model.changeJokeStatus()?.let {
           communication.showState(State.Progress)
        }
    }

    fun observe(owner: LifecycleOwner,observer: Observer<BaseViewModel.State>) =
        communication.observe(owner,observer)

    sealed class State {
        fun show(
            process: ShowView,
            button: EnableView,
            textView: ShowText,
            imageButton: ShowImage
        ){
            show(process,button)
            show(textView,imageButton)
        }

        protected open fun show(progress: ShowView,button: EnableView){}
        protected open fun show(textView: ShowText,imageButton: ShowImage){}

        object Progress: State() {
            override fun show(progress: ShowView, button: EnableView) {
                progress.show(true)
                button.enable(false)
            }
        }

        class Initial(private val text:String, @DrawableRes private val id: Int): State(){

            override fun show(progress: ShowView, button: EnableView) {
                progress.show(true)
                button.enable(false)
            }

            override fun show(textView: ShowText, imageButton: ShowImage) {
                textView.show(text)
                imageButton.show(id)
            }

        }
    }
}