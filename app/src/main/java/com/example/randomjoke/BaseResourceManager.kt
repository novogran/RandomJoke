package com.example.randomjoke

import android.content.Context

class BaseResourceManager(private val context: Context) : ResourceManager {

    override fun getString(stringResId: Int) = context.getString(stringResId)

}