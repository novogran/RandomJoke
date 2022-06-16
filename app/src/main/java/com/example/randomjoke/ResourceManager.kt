package com.example.randomjoke

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int):String
}