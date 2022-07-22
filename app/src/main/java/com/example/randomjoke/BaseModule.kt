package com.example.randomjoke

import androidx.lifecycle.ViewModel
import com.example.randomjoke.presentation.BaseCommunication
import com.example.randomjoke.presentation.BaseViewModel

interface Module<T: ViewModel>{
    fun getViewModel():T

    abstract class Base<E,T:BaseViewModel<E>>:Module<T>{
        protected abstract fun getCommunications(): BaseCommunication<E>
    }
}