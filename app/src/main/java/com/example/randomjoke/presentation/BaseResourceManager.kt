package com.example.randomjoke.presentation

import android.content.Context
import com.example.randomjoke.core.ResourceManager

class BaseResourceManager(private val context: Context) : ResourceManager {

    override fun getString(stringResId: Int) = context.getString(stringResId)

}