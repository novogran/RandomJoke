package com.example.randomjoke.domain

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int):String
}