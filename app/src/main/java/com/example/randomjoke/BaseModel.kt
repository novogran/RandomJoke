package com.example.randomjoke

import com.example.randomjoke.presentation.BaseCommunication
import com.example.randomjoke.presentation.BaseViewModel

abstract class BaseModel<E,T: BaseViewModel<E>> {
    abstract fun getViewModel(): T
    abstract fun getCommunications(): BaseCommunication<E>
}