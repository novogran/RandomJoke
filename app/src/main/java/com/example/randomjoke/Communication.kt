package com.example.randomjoke

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface Communication {
    fun showData(data: Pair<String, Int>)

    fun observe(owner: LifecycleOwner,observer: Observer<Pair<String,Int>>)
}