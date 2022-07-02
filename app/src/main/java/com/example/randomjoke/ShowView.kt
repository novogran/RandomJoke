package com.example.randomjoke

import androidx.annotation.DrawableRes

interface ShowView {
    fun show(show:Boolean)
}

interface ShowImage{
    fun show(@DrawableRes id:Int)
}

interface ShowText{
    fun show(text:String)
}

interface EnableView{
    fun enable(enable:Boolean)
}
