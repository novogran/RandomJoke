package com.example.randomjoke.core

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int):String
}