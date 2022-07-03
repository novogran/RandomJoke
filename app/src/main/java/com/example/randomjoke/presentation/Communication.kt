package com.example.randomjoke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface Communication {

    fun showState(state: State)

    fun observe(owner: LifecycleOwner,observer: Observer<State>)

    fun isState(type: Int): Boolean
}